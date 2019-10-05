package mdapi;

import ctp.thostmduserapi.*;

class mdspiImpl extends CThostFtdcMdSpi{
	final static String m_BrokerId = "9999";
	final static String m_UserId = "070624";
	final static String m_InvestorId = "070624";
	final static String m_PassWord = "passwd"; 
	final static String m_TradingDay = "20181122";
	final static String m_AccountId = "070624";
	final static String m_CurrencyId = "CNY";
	mdspiImpl(CThostFtdcMdApi mdapi)
	{
		m_mdapi =  mdapi;
	}
	
	public void OnFrontConnected(){
		System.out.println("On Front Connected");
		CThostFtdcReqUserLoginField field = new CThostFtdcReqUserLoginField();
		field.setBrokerID(m_BrokerId);
		field.setUserID(m_UserId);
		field.setPassword(m_PassWord);
		m_mdapi.ReqUserLogin(field, 0);
		
	}
	
	public void OnRspUserLogin(CThostFtdcRspUserLoginField pRspUserLogin, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		if (pRspUserLogin != null) {
			System.out.printf("Brokerid[%s]\n",pRspUserLogin.getBrokerID());			
		}
		if (pRspInfo != null )
		{
			System.out.printf("OnRspUserLogin ErrorMsg[%s]\n",pRspInfo.getErrorMsg());
		}
		String[] instruementid = new String[1];
		//订阅合约号修改这里，如果运行成功没收到行情，参见如下解决
		//https://blog.csdn.net/pjjing/article/details/100532276
		instruementid[0]="au1912";		
		m_mdapi.SubscribeMarketData(instruementid,1);
	}
	
	public void OnRtnDepthMarketData(CThostFtdcDepthMarketDataField pDepthMarketData) {
		if (pDepthMarketData != null)
		{
			System.out.printf("AskPrice1[%f]BidPrice1[%f]\n",
				pDepthMarketData.getAskPrice1(),pDepthMarketData.getBidPrice1());
		}
		else
		{
			System.out.printf("NULL obj\n");
		}
	}	
	private CThostFtdcMdApi m_mdapi;
}

public class MdapiDemo {
	static{
		System.loadLibrary("thostmduserapi_se");
		System.loadLibrary("thostmduserapi_wrap");
	}
	//这是7*24模拟环境，正式生产环境见群文档
	final static String ctp1_MdAddress = "tcp://180.168.146.187:10131";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CThostFtdcMdApi mdApi = CThostFtdcMdApi.CreateFtdcMdApi();
		mdspiImpl pMdspiImpl = new mdspiImpl(mdApi);
		mdApi.RegisterSpi(pMdspiImpl);
		mdApi.RegisterFront(ctp1_MdAddress);
		mdApi.Init();
		mdApi.Join();		
		return;
	}
}

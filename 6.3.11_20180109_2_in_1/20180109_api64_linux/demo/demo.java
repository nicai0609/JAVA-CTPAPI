import ctp.thostapi.*;
import java.util.Vector;
import java.util.Iterator;



class TraderSpiImpl extends CThostFtdcTraderSpi{	
	final static String m_BrokerId = "9999";
	final static String m_UserId = "070624";
	final static String m_InvestorId = "070624";
	final static String m_PassWord = "passwd"; 
	final static String m_TradingDay = "20181122";
	final static String m_AccountId = "070624";
	final static String m_CurrencyId = "CNY";
	TraderSpiImpl(CThostFtdcTraderApi traderapi,Vector<String> instrs)
	{
		m_traderapi =  traderapi;
		m_instr_vec = instrs;
	}
	
	@Override
	public void OnFrontConnected(){
		System.out.println("On Front Connected");
		CThostFtdcReqUserLoginField field = new CThostFtdcReqUserLoginField();
		field.setBrokerID(m_BrokerId);
		field.setUserID(m_UserId);
		field.setPassword(m_PassWord);
		field.setUserProductInfo("JAVA_API");
		m_traderapi.ReqUserLogin(field,0);
		System.out.println("Send login ok");
	}
	
	@Override
	public void OnRspUserLogin(CThostFtdcRspUserLoginField pRspUserLogin, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast)
	{
		if (pRspInfo != null && pRspInfo.getErrorID() != 0)
		{
			System.out.printf("Login ErrorID[%d] ErrMsg[%s]\n", pRspInfo.getErrorID(), pRspInfo.getErrorMsg());

			return;
		}
		System.out.println("Login success!!!");
		CThostFtdcQryTradingAccountField qryTradingAccount = new CThostFtdcQryTradingAccountField();
		qryTradingAccount.setBrokerID(m_BrokerId);
		qryTradingAccount.setCurrencyID(m_CurrencyId);;
		qryTradingAccount.setInvestorID(m_InvestorId);
		//m_traderapi.ReqQryTradingAccount(qryTradingAccount, 1);
		
		CThostFtdcQrySettlementInfoField qrysettlement = new CThostFtdcQrySettlementInfoField();
		qrysettlement.setBrokerID(m_BrokerId);
		qrysettlement.setInvestorID(m_InvestorId);
		qrysettlement.setTradingDay(m_TradingDay);
		qrysettlement.setAccountID(m_AccountId);
		qrysettlement.setCurrencyID(m_CurrencyId);
		//m_traderapi.ReqQrySettlementInfo(qrysettlement, 2);
		
		CThostFtdcQryInstrumentField qryInstr = new CThostFtdcQryInstrumentField();
		m_traderapi.ReqQryInstrument(qryInstr, 3);
		System.out.println("Query success!!!");
	}
	
	@Override
	public void OnRspQryTradingAccount(CThostFtdcTradingAccountField pTradingAccount, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) 
	{
		if (pRspInfo != null && pRspInfo.getErrorID() != 0)
		{
			System.out.printf("OnRspQryTradingAccount ErrorID[%d] ErrMsg[%s]\n", pRspInfo.getErrorID(), pRspInfo.getErrorMsg());

			return;
		}
		
		if (pTradingAccount != null)
		{
			System.out.printf("Balance[%f]Available[%f]WithdrawQuota[%f]Credit[%f]\n",
				pTradingAccount.getBalance(), pTradingAccount.getAvailable(), pTradingAccount.getWithdrawQuota(),
				pTradingAccount.getCredit());
		}
		else
		{
			System.out.printf("NULL obj\n");
		}
	}
	
	public void  OnRspQrySettlementInfo(CThostFtdcSettlementInfoField pSettlementInfo, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast)
	{
		if (pRspInfo != null && pRspInfo.getErrorID() != 0)
		{
			System.out.printf("OnRspQrySettlementInfo ErrorID[%d] ErrMsg[%s]\n", pRspInfo.getErrorID(), pRspInfo.getErrorMsg());

			return;
		}
		
		if (pSettlementInfo != null)
		{
			System.out.printf("%s",pSettlementInfo.getContent());
		}
		else
		{
			System.out.printf("NULL obj\n");
		}
	}
	
	public void OnRspQryInstrument(CThostFtdcInstrumentField pInstrument, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast)
	{
		if (pRspInfo != null && pRspInfo.getErrorID() != 0)
		{
			System.out.printf("OnRspQryInstrument ErrorID[%d] ErrMsg[%s]\n", pRspInfo.getErrorID(), pRspInfo.getErrorMsg());
			return;
		}
		if (pInstrument != null)
		{
			//System.out.printf("%s\n",pInstrument.getInstrumentID());
			m_instr_vec.add(pInstrument.getInstrumentID());
		}
		else
		{
			System.out.printf("NULL obj\n");
		}
	}
	
	private CThostFtdcTraderApi m_traderapi;
	private Vector<String> m_instr_vec;
}

class mdspiImpl extends CThostFtdcMdSpi{
	final static String m_BrokerId = "9999";
	final static String m_UserId = "070624";
	final static String m_InvestorId = "070624";
	final static String m_PassWord = "passwd"; 
	final static String m_TradingDay = "20181122";
	final static String m_AccountId = "070624";
	final static String m_CurrencyId = "CNY";
	mdspiImpl(CThostFtdcMdApi mdapi,Vector<String> instrs)
	{
		m_mdapi =  mdapi;
		m_instr_vec = instrs;
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
		String[] instruementid = new String[1];
		Iterator iterator = m_instr_vec.iterator();
		while (iterator.hasNext()) {
			instruementid[0]=iterator.next().toString();
			m_mdapi.SubscribeMarketData(instruementid,1);
			System.out.println(instruementid[0]);
		}
	}
	
	public void OnRtnDepthMarketData(CThostFtdcDepthMarketDataField pDepthMarketData) {
		if (pDepthMarketData != null)
		{
			System.out.printf("InstrumentID[%s]AskPrice1[%f]BidPrice1[%f]\n",
					pDepthMarketData.getInstrumentID(),pDepthMarketData.getAskPrice1(),pDepthMarketData.getBidPrice1());
		}
		else
		{
			System.out.printf("NULL obj\n");
		}
	}	
	private CThostFtdcMdApi m_mdapi;
	private Vector<String> m_instr_vec;
}


public class demo {

	static{
		System.loadLibrary("thosttraderapi");
		System.loadLibrary("thostmduserapi");
		System.loadLibrary("thostapi_wrap");
	}
	final static String ctp1_TradeAddress = "tcp://180.168.146.187:10000";
	final static String ctp1_MdAddress = "tcp://180.168.146.187:10010";
	static Vector<String> instr_vec = new Vector<String>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(System.getProperty("java.library.path"));
		CThostFtdcTraderApi traderApi = CThostFtdcTraderApi.CreateFtdcTraderApi("trade");
		TraderSpiImpl pTraderSpi = new TraderSpiImpl(traderApi,instr_vec);
		traderApi.RegisterSpi(pTraderSpi);
		traderApi.RegisterFront(ctp1_TradeAddress);
		traderApi.SubscribePublicTopic(THOST_TE_RESUME_TYPE.THOST_TERT_QUICK);
		traderApi.SubscribePrivateTopic(THOST_TE_RESUME_TYPE.THOST_TERT_QUICK);
		traderApi.Init();
		//这里sleep是为了保证traderapi的登录查询成功
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		CThostFtdcMdApi mdApi = CThostFtdcMdApi.CreateFtdcMdApi("md");
		mdspiImpl pMdspiImpl = new mdspiImpl(mdApi,instr_vec);
		mdApi.RegisterSpi(pMdspiImpl);
		mdApi.RegisterFront(ctp1_MdAddress);
		mdApi.Init();
		
		traderApi.Join();
		mdApi.Join();
		return;
	}
}
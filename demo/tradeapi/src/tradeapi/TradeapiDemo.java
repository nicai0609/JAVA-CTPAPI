package tradeapi;

import ctp.thosttraderapi.*;;

class TraderSpiImpl extends CThostFtdcTraderSpi{	
	//final static String m_BrokerId = "9999";
	//final static String m_UserId = "070624";	
	final static String m_BrokerId = "8000";
	final static String m_UserId = "8000_admin";
	final static String m_PassWord = "1"; 
	final static String m_InvestorId = "070624";
	final static String m_TradingDay = "20181122";
	final static String m_AccountId = "070624";
	final static String m_CurrencyId = "CNY";
	final static String m_AppId = "simnow_client_test";
	final static String m_AuthCode = "0000000000000000"; 
	TraderSpiImpl(CThostFtdcTraderApi traderapi)
	{
		m_traderapi =  traderapi;
	}
	
	@Override
	public void OnFrontConnected(){
		System.out.println("On Front Connected");
		CThostFtdcReqAuthenticateField field = new CThostFtdcReqAuthenticateField();
		field.setBrokerID(m_BrokerId);
		field.setUserID(m_UserId);
		field.setAppID(m_AppId);
		field.setAuthCode(m_AuthCode);
    	m_traderapi.ReqAuthenticate(field, 0);
		System.out.println("Send ReqAuthenticate ok");
	}
	
	public void OnFrontDisconnected(int nReason) {
		System.out.printf("OnFrontDisconnected nReason[%d]\n", nReason);
	};
	
	@Override
	public void OnRspAuthenticate(CThostFtdcRspAuthenticateField pRspAuthenticateField, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) 
	{
		if (pRspInfo != null && pRspInfo.getErrorID() != 0)
        {
             System.out.printf("Login ErrorID[%d] ErrMsg[%s]\n", pRspInfo.getErrorID(), pRspInfo.getErrorMsg());

             return;
        }
        System.out.println("OnRspAuthenticate success!!!");
		CThostFtdcReqUserLoginField field = new CThostFtdcReqUserLoginField();
        field.setBrokerID(m_BrokerId);
        field.setUserID(m_UserId);
        field.setPassword(m_PassWord);
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
		m_traderapi.ReqQrySettlementInfo(qrysettlement, 2);
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
	
	private CThostFtdcTraderApi m_traderapi;
}

public class TradeapiDemo {

	static{
		System.loadLibrary("thosttraderapi_se");
		System.loadLibrary("thosttraderapi_wrap");
	}
	final static String ctp1_TradeAddress = "tcp://180.168.146.187:10130";
	//final static String ctp1_TradeAddress = "tcp://172.24.125.199:50233";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(System.getProperty("java.library.path"));
		CThostFtdcTraderApi traderApi = CThostFtdcTraderApi.CreateFtdcTraderApi();
		TraderSpiImpl pTraderSpi = new TraderSpiImpl(traderApi);
		traderApi.RegisterSpi(pTraderSpi);
		traderApi.RegisterFront(ctp1_TradeAddress);
		traderApi.SubscribePublicTopic(THOST_TE_RESUME_TYPE.THOST_TERT_RESTART);
		traderApi.SubscribePrivateTopic(THOST_TE_RESUME_TYPE.THOST_TERT_RESTART);
		traderApi.Init();		
		traderApi.Join();
		return;
	}
}
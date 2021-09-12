//本demo流程是认证--->登录--->确认结算单--->下单
package tradeapi;

import ctp.thosttraderapi.*;

class TraderSpiImpl extends CThostFtdcTraderSpi{
    final static String m_BrokerId = "9999";
    final static String m_UserId = "070624";
    final static String m_InvestorId = "070624";
    final static String m_PassWord = "070624"; //替换为自己的账号密码
    final static String m_TradingDay = "20161111";
    final static String m_AccountId = "cs000005";
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
		
		/*
		查询资金账户
        System.out.println("Login success!!!");
        CThostFtdcQryTradingAccountField qryTradingAccount = new CThostFtdcQryTradingAccountField();
        qryTradingAccount.setBrokerID(m_BrokerId);
        qryTradingAccount.setCurrencyID(m_CurrencyId);;
        qryTradingAccount.setInvestorID(m_InvestorId);
        m_traderapi.ReqQryTradingAccount(qryTradingAccount, 1);
		*/
		
		/*
		查询结算单
        CThostFtdcQrySettlementInfoField qrysettlement = new CThostFtdcQrySettlementInfoField();
        qrysettlement.setBrokerID(m_BrokerId);
        qrysettlement.setInvestorID(m_InvestorId);
        qrysettlement.setTradingDay(m_TradingDay);
        qrysettlement.setAccountID(m_AccountId);
        qrysettlement.setCurrencyID(m_CurrencyId);
        m_traderapi.ReqQrySettlementInfo(qrysettlement, 2);
		*/

        //确认结算单
        CThostFtdcSettlementInfoConfirmField confirmfield = new CThostFtdcSettlementInfoConfirmField();
        m_traderapi.ReqSettlementInfoConfirm(confirmfield, 0);
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

    public void OnRspSettlementInfoConfirm(CThostFtdcSettlementInfoConfirmField pSettlementInfoConfirm, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast )
    {
        if (pSettlementInfoConfirm != null)
        {
            System.out.printf("OnRspSettlementInfoConfirm Ok\n");
        }
        else
        {
            System.out.printf("OnRspSettlementInfoConfirm Null\n");
        }
        //在确认结算单结果中报单，请确认合约是否是有效合约
        String instrumentID = "au2112";
        placeOrder(instrumentID, thosttraderapiConstants.THOST_FTDC_D_Buy, thosttraderapiConstants.THOST_FTDC_OF_Open, 1, 380);
    }

    public void placeOrder( String instrumentID, char direction, char offsetFlag, int volume, double price )
    {
        CThostFtdcInputOrderField orderfield = new CThostFtdcInputOrderField();
        orderfield.setBrokerID(m_BrokerId);
        orderfield.setUserID(m_UserId);
        orderfield.setInvestorID(m_InvestorId);
        orderfield.setInstrumentID(instrumentID);
        orderfield.setDirection(direction);
        orderfield.setCombOffsetFlag(Character.toString(offsetFlag));
        orderfield.setCombHedgeFlag(Character.toString(thosttraderapiConstants.THOST_FTDC_HF_Speculation));
        orderfield.setVolumeTotalOriginal(volume);
        orderfield.setTimeCondition(thosttraderapiConstants.THOST_FTDC_TC_GFD);
        orderfield.setVolumeCondition(thosttraderapiConstants.THOST_FTDC_VC_AV);
        orderfield.setMinVolume(1);
        orderfield.setForceCloseReason(thosttraderapiConstants.THOST_FTDC_FCC_NotForceClose);
        orderfield.setUserForceClose(0);
        orderfield.setContingentCondition(thosttraderapiConstants.THOST_FTDC_CC_Immediately);
        orderfield.setLimitPrice(price);
        orderfield.setOrderPriceType(thosttraderapiConstants.THOST_FTDC_OPT_LimitPrice);
        m_traderapi.ReqOrderInsert(orderfield, 0);
        System.out.printf("ReqOrderInsert Success\n");
    }
	
    public void OnRspOrderInsert( CThostFtdcInputOrderField pInputOrder, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast )
    {
        if (pInputOrder == null || (pRspInfo != null && pRspInfo.getErrorID() != 0))
        {
            System.out.printf("OnRspOrderInsert failed ErrorID[%d] ErrMsg[%s]\n", pRspInfo.getErrorID(), pRspInfo.getErrorMsg());
        }
        else
        {
            System.out.printf("OnRspOrderInsert success.\n");
        }
    }

    public void OnRtnOrder( CThostFtdcOrderField pOrder )
    {
        System.out.printf("OnRtnOrder\n");
        if(pOrder!= null)
        {
            System.out.printf("OrderStatus[%c]\n",pOrder.getOrderStatus());
            System.out.printf("OrderSysID[%s]\n",pOrder.getOrderSysID());
        }
    }

    public void OnRtnTrade( CThostFtdcTradeField pTrade )
    {
        System.out.printf("OnRtnTrade\n");
        if(pTrade!= null)
        {
            System.out.printf("Price[%f]\n",pTrade.getPrice());
            System.out.printf("Volume[%d]\n",pTrade.getVolume());
            System.out.printf("OrderSysID[%s]\n",pTrade.getOrderSysID());
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
		System.out.printf("CTP API Version [%s]\n",traderApi.GetApiVersion());//输出api版本号
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
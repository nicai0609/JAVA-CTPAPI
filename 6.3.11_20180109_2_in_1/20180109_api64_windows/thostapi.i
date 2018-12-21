%module(directors="1") thosttraderapi 
%include "various.i"
%apply char **STRING_ARRAY { char *ppInstrumentID[] }
%{ 
#include "ThostFtdcMdApi.h"
#include "ThostFtdcTraderApi.h"
%} 
%feature("director") CThostFtdcMdSpi;
%ignore THOST_FTDC_VTC_BankBankToFuture;
%ignore THOST_FTDC_VTC_BankFutureToBank;
%ignore THOST_FTDC_VTC_FutureBankToFuture;
%ignore THOST_FTDC_VTC_FutureFutureToBank;
%ignore THOST_FTDC_FTC_BankLaunchBankToBroker;
%ignore THOST_FTDC_FTC_BrokerLaunchBankToBroker;
%ignore THOST_FTDC_FTC_BankLaunchBrokerToBank;
%ignore THOST_FTDC_FTC_BrokerLaunchBrokerToBank;

%include "ThostFtdcUserApiDataType.h"
%include "ThostFtdcUserApiStruct.h" 
%include "ThostFtdcMdApi.h"
%feature("director") CThostFtdcTraderSpi;
%include "ThostFtdcTraderApi.h"
/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package test.thostmduserapi;

public class CThostFtdcInvestorPositionDetailField {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CThostFtdcInvestorPositionDetailField(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CThostFtdcInvestorPositionDetailField obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        thostmduserapiJNI.delete_CThostFtdcInvestorPositionDetailField(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setInstrumentID(String value) {
    thostmduserapiJNI.CThostFtdcInvestorPositionDetailField_InstrumentID_set(swigCPtr, this, value);
  }

  public String getInstrumentID() {
    return thostmduserapiJNI.CThostFtdcInvestorPositionDetailField_InstrumentID_get(swigCPtr, this);
  }

  public void setBrokerID(String value) {
    thostmduserapiJNI.CThostFtdcInvestorPositionDetailField_BrokerID_set(swigCPtr, this, value);
  }

  public String getBrokerID() {
    return thostmduserapiJNI.CThostFtdcInvestorPositionDetailField_BrokerID_get(swigCPtr, this);
  }

  public void setInvestorID(String value) {
    thostmduserapiJNI.CThostFtdcInvestorPositionDetailField_InvestorID_set(swigCPtr, this, value);
  }

  public String getInvestorID() {
    return thostmduserapiJNI.CThostFtdcInvestorPositionDetailField_InvestorID_get(swigCPtr, this);
  }

  public void setHedgeFlag(char value) {
    thostmduserapiJNI.CThostFtdcInvestorPositionDetailField_HedgeFlag_set(swigCPtr, this, value);
  }

  public char getHedgeFlag() {
    return thostmduserapiJNI.CThostFtdcInvestorPositionDetailField_HedgeFlag_get(swigCPtr, this);
  }

  public void setDirection(char value) {
    thostmduserapiJNI.CThostFtdcInvestorPositionDetailField_Direction_set(swigCPtr, this, value);
  }

  public char getDirection() {
    return thostmduserapiJNI.CThostFtdcInvestorPositionDetailField_Direction_get(swigCPtr, this);
  }

  public void setOpenDate(String value) {
    thostmduserapiJNI.CThostFtdcInvestorPositionDetailField_OpenDate_set(swigCPtr, this, value);
  }

  public String getOpenDate() {
    return thostmduserapiJNI.CThostFtdcInvestorPositionDetailField_OpenDate_get(swigCPtr, this);
  }

  public void setTradeID(String value) {
    thostmduserapiJNI.CThostFtdcInvestorPositionDetailField_TradeID_set(swigCPtr, this, value);
  }

  public String getTradeID() {
    return thostmduserapiJNI.CThostFtdcInvestorPositionDetailField_TradeID_get(swigCPtr, this);
  }

  public void setVolume(int value) {
    thostmduserapiJNI.CThostFtdcInvestorPositionDetailField_Volume_set(swigCPtr, this, value);
  }

  public int getVolume() {
    return thostmduserapiJNI.CThostFtdcInvestorPositionDetailField_Volume_get(swigCPtr, this);
  }

  public void setOpenPrice(double value) {
    thostmduserapiJNI.CThostFtdcInvestorPositionDetailField_OpenPrice_set(swigCPtr, this, value);
  }

  public double getOpenPrice() {
    return thostmduserapiJNI.CThostFtdcInvestorPositionDetailField_OpenPrice_get(swigCPtr, this);
  }

  public void setTradingDay(String value) {
    thostmduserapiJNI.CThostFtdcInvestorPositionDetailField_TradingDay_set(swigCPtr, this, value);
  }

  public String getTradingDay() {
    return thostmduserapiJNI.CThostFtdcInvestorPositionDetailField_TradingDay_get(swigCPtr, this);
  }

  public void setSettlementID(int value) {
    thostmduserapiJNI.CThostFtdcInvestorPositionDetailField_SettlementID_set(swigCPtr, this, value);
  }

  public int getSettlementID() {
    return thostmduserapiJNI.CThostFtdcInvestorPositionDetailField_SettlementID_get(swigCPtr, this);
  }

  public void setTradeType(char value) {
    thostmduserapiJNI.CThostFtdcInvestorPositionDetailField_TradeType_set(swigCPtr, this, value);
  }

  public char getTradeType() {
    return thostmduserapiJNI.CThostFtdcInvestorPositionDetailField_TradeType_get(swigCPtr, this);
  }

  public void setCombInstrumentID(String value) {
    thostmduserapiJNI.CThostFtdcInvestorPositionDetailField_CombInstrumentID_set(swigCPtr, this, value);
  }

  public String getCombInstrumentID() {
    return thostmduserapiJNI.CThostFtdcInvestorPositionDetailField_CombInstrumentID_get(swigCPtr, this);
  }

  public void setExchangeID(String value) {
    thostmduserapiJNI.CThostFtdcInvestorPositionDetailField_ExchangeID_set(swigCPtr, this, value);
  }

  public String getExchangeID() {
    return thostmduserapiJNI.CThostFtdcInvestorPositionDetailField_ExchangeID_get(swigCPtr, this);
  }

  public void setCloseProfitByDate(double value) {
    thostmduserapiJNI.CThostFtdcInvestorPositionDetailField_CloseProfitByDate_set(swigCPtr, this, value);
  }

  public double getCloseProfitByDate() {
    return thostmduserapiJNI.CThostFtdcInvestorPositionDetailField_CloseProfitByDate_get(swigCPtr, this);
  }

  public void setCloseProfitByTrade(double value) {
    thostmduserapiJNI.CThostFtdcInvestorPositionDetailField_CloseProfitByTrade_set(swigCPtr, this, value);
  }

  public double getCloseProfitByTrade() {
    return thostmduserapiJNI.CThostFtdcInvestorPositionDetailField_CloseProfitByTrade_get(swigCPtr, this);
  }

  public void setPositionProfitByDate(double value) {
    thostmduserapiJNI.CThostFtdcInvestorPositionDetailField_PositionProfitByDate_set(swigCPtr, this, value);
  }

  public double getPositionProfitByDate() {
    return thostmduserapiJNI.CThostFtdcInvestorPositionDetailField_PositionProfitByDate_get(swigCPtr, this);
  }

  public void setPositionProfitByTrade(double value) {
    thostmduserapiJNI.CThostFtdcInvestorPositionDetailField_PositionProfitByTrade_set(swigCPtr, this, value);
  }

  public double getPositionProfitByTrade() {
    return thostmduserapiJNI.CThostFtdcInvestorPositionDetailField_PositionProfitByTrade_get(swigCPtr, this);
  }

  public void setMargin(double value) {
    thostmduserapiJNI.CThostFtdcInvestorPositionDetailField_Margin_set(swigCPtr, this, value);
  }

  public double getMargin() {
    return thostmduserapiJNI.CThostFtdcInvestorPositionDetailField_Margin_get(swigCPtr, this);
  }

  public void setExchMargin(double value) {
    thostmduserapiJNI.CThostFtdcInvestorPositionDetailField_ExchMargin_set(swigCPtr, this, value);
  }

  public double getExchMargin() {
    return thostmduserapiJNI.CThostFtdcInvestorPositionDetailField_ExchMargin_get(swigCPtr, this);
  }

  public void setMarginRateByMoney(double value) {
    thostmduserapiJNI.CThostFtdcInvestorPositionDetailField_MarginRateByMoney_set(swigCPtr, this, value);
  }

  public double getMarginRateByMoney() {
    return thostmduserapiJNI.CThostFtdcInvestorPositionDetailField_MarginRateByMoney_get(swigCPtr, this);
  }

  public void setMarginRateByVolume(double value) {
    thostmduserapiJNI.CThostFtdcInvestorPositionDetailField_MarginRateByVolume_set(swigCPtr, this, value);
  }

  public double getMarginRateByVolume() {
    return thostmduserapiJNI.CThostFtdcInvestorPositionDetailField_MarginRateByVolume_get(swigCPtr, this);
  }

  public void setLastSettlementPrice(double value) {
    thostmduserapiJNI.CThostFtdcInvestorPositionDetailField_LastSettlementPrice_set(swigCPtr, this, value);
  }

  public double getLastSettlementPrice() {
    return thostmduserapiJNI.CThostFtdcInvestorPositionDetailField_LastSettlementPrice_get(swigCPtr, this);
  }

  public void setSettlementPrice(double value) {
    thostmduserapiJNI.CThostFtdcInvestorPositionDetailField_SettlementPrice_set(swigCPtr, this, value);
  }

  public double getSettlementPrice() {
    return thostmduserapiJNI.CThostFtdcInvestorPositionDetailField_SettlementPrice_get(swigCPtr, this);
  }

  public void setCloseVolume(int value) {
    thostmduserapiJNI.CThostFtdcInvestorPositionDetailField_CloseVolume_set(swigCPtr, this, value);
  }

  public int getCloseVolume() {
    return thostmduserapiJNI.CThostFtdcInvestorPositionDetailField_CloseVolume_get(swigCPtr, this);
  }

  public void setCloseAmount(double value) {
    thostmduserapiJNI.CThostFtdcInvestorPositionDetailField_CloseAmount_set(swigCPtr, this, value);
  }

  public double getCloseAmount() {
    return thostmduserapiJNI.CThostFtdcInvestorPositionDetailField_CloseAmount_get(swigCPtr, this);
  }

  public void setInvestUnitID(String value) {
    thostmduserapiJNI.CThostFtdcInvestorPositionDetailField_InvestUnitID_set(swigCPtr, this, value);
  }

  public String getInvestUnitID() {
    return thostmduserapiJNI.CThostFtdcInvestorPositionDetailField_InvestUnitID_get(swigCPtr, this);
  }

  public CThostFtdcInvestorPositionDetailField() {
    this(thostmduserapiJNI.new_CThostFtdcInvestorPositionDetailField(), true);
  }

}
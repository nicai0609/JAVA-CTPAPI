/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.11
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package test.thosttraderapi;

public class CThostFtdcExchangeOptionSelfCloseActionField {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CThostFtdcExchangeOptionSelfCloseActionField(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CThostFtdcExchangeOptionSelfCloseActionField obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        thosttradeapiJNI.delete_CThostFtdcExchangeOptionSelfCloseActionField(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setExchangeID(String value) {
    thosttradeapiJNI.CThostFtdcExchangeOptionSelfCloseActionField_ExchangeID_set(swigCPtr, this, value);
  }

  public String getExchangeID() {
    return thosttradeapiJNI.CThostFtdcExchangeOptionSelfCloseActionField_ExchangeID_get(swigCPtr, this);
  }

  public void setOptionSelfCloseSysID(String value) {
    thosttradeapiJNI.CThostFtdcExchangeOptionSelfCloseActionField_OptionSelfCloseSysID_set(swigCPtr, this, value);
  }

  public String getOptionSelfCloseSysID() {
    return thosttradeapiJNI.CThostFtdcExchangeOptionSelfCloseActionField_OptionSelfCloseSysID_get(swigCPtr, this);
  }

  public void setActionFlag(char value) {
    thosttradeapiJNI.CThostFtdcExchangeOptionSelfCloseActionField_ActionFlag_set(swigCPtr, this, value);
  }

  public char getActionFlag() {
    return thosttradeapiJNI.CThostFtdcExchangeOptionSelfCloseActionField_ActionFlag_get(swigCPtr, this);
  }

  public void setActionDate(String value) {
    thosttradeapiJNI.CThostFtdcExchangeOptionSelfCloseActionField_ActionDate_set(swigCPtr, this, value);
  }

  public String getActionDate() {
    return thosttradeapiJNI.CThostFtdcExchangeOptionSelfCloseActionField_ActionDate_get(swigCPtr, this);
  }

  public void setActionTime(String value) {
    thosttradeapiJNI.CThostFtdcExchangeOptionSelfCloseActionField_ActionTime_set(swigCPtr, this, value);
  }

  public String getActionTime() {
    return thosttradeapiJNI.CThostFtdcExchangeOptionSelfCloseActionField_ActionTime_get(swigCPtr, this);
  }

  public void setTraderID(String value) {
    thosttradeapiJNI.CThostFtdcExchangeOptionSelfCloseActionField_TraderID_set(swigCPtr, this, value);
  }

  public String getTraderID() {
    return thosttradeapiJNI.CThostFtdcExchangeOptionSelfCloseActionField_TraderID_get(swigCPtr, this);
  }

  public void setInstallID(int value) {
    thosttradeapiJNI.CThostFtdcExchangeOptionSelfCloseActionField_InstallID_set(swigCPtr, this, value);
  }

  public int getInstallID() {
    return thosttradeapiJNI.CThostFtdcExchangeOptionSelfCloseActionField_InstallID_get(swigCPtr, this);
  }

  public void setOptionSelfCloseLocalID(String value) {
    thosttradeapiJNI.CThostFtdcExchangeOptionSelfCloseActionField_OptionSelfCloseLocalID_set(swigCPtr, this, value);
  }

  public String getOptionSelfCloseLocalID() {
    return thosttradeapiJNI.CThostFtdcExchangeOptionSelfCloseActionField_OptionSelfCloseLocalID_get(swigCPtr, this);
  }

  public void setActionLocalID(String value) {
    thosttradeapiJNI.CThostFtdcExchangeOptionSelfCloseActionField_ActionLocalID_set(swigCPtr, this, value);
  }

  public String getActionLocalID() {
    return thosttradeapiJNI.CThostFtdcExchangeOptionSelfCloseActionField_ActionLocalID_get(swigCPtr, this);
  }

  public void setParticipantID(String value) {
    thosttradeapiJNI.CThostFtdcExchangeOptionSelfCloseActionField_ParticipantID_set(swigCPtr, this, value);
  }

  public String getParticipantID() {
    return thosttradeapiJNI.CThostFtdcExchangeOptionSelfCloseActionField_ParticipantID_get(swigCPtr, this);
  }

  public void setClientID(String value) {
    thosttradeapiJNI.CThostFtdcExchangeOptionSelfCloseActionField_ClientID_set(swigCPtr, this, value);
  }

  public String getClientID() {
    return thosttradeapiJNI.CThostFtdcExchangeOptionSelfCloseActionField_ClientID_get(swigCPtr, this);
  }

  public void setBusinessUnit(String value) {
    thosttradeapiJNI.CThostFtdcExchangeOptionSelfCloseActionField_BusinessUnit_set(swigCPtr, this, value);
  }

  public String getBusinessUnit() {
    return thosttradeapiJNI.CThostFtdcExchangeOptionSelfCloseActionField_BusinessUnit_get(swigCPtr, this);
  }

  public void setOrderActionStatus(char value) {
    thosttradeapiJNI.CThostFtdcExchangeOptionSelfCloseActionField_OrderActionStatus_set(swigCPtr, this, value);
  }

  public char getOrderActionStatus() {
    return thosttradeapiJNI.CThostFtdcExchangeOptionSelfCloseActionField_OrderActionStatus_get(swigCPtr, this);
  }

  public void setUserID(String value) {
    thosttradeapiJNI.CThostFtdcExchangeOptionSelfCloseActionField_UserID_set(swigCPtr, this, value);
  }

  public String getUserID() {
    return thosttradeapiJNI.CThostFtdcExchangeOptionSelfCloseActionField_UserID_get(swigCPtr, this);
  }

  public void setBranchID(String value) {
    thosttradeapiJNI.CThostFtdcExchangeOptionSelfCloseActionField_BranchID_set(swigCPtr, this, value);
  }

  public String getBranchID() {
    return thosttradeapiJNI.CThostFtdcExchangeOptionSelfCloseActionField_BranchID_get(swigCPtr, this);
  }

  public void setIPAddress(String value) {
    thosttradeapiJNI.CThostFtdcExchangeOptionSelfCloseActionField_IPAddress_set(swigCPtr, this, value);
  }

  public String getIPAddress() {
    return thosttradeapiJNI.CThostFtdcExchangeOptionSelfCloseActionField_IPAddress_get(swigCPtr, this);
  }

  public void setMacAddress(String value) {
    thosttradeapiJNI.CThostFtdcExchangeOptionSelfCloseActionField_MacAddress_set(swigCPtr, this, value);
  }

  public String getMacAddress() {
    return thosttradeapiJNI.CThostFtdcExchangeOptionSelfCloseActionField_MacAddress_get(swigCPtr, this);
  }

  public CThostFtdcExchangeOptionSelfCloseActionField() {
    this(thosttradeapiJNI.new_CThostFtdcExchangeOptionSelfCloseActionField(), true);
  }

}
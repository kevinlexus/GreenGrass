/**
 * This class is the controller for the main view for the application. It is specified as
 * the "controller" of the Main view class.
 *
 * TODO - Replace this content of this view to suite the needs of your application.
 */
var askObjPanel;
Ext.define('BillWebApp.view.main.Panel1Controller', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.panel1controller',

    // Проверка при включении чекбокса
    onChangePeriodType: function (chk , newValue , oldValue , eOpts) {
        //получить выбранные id
        var store = this.getViewModel().getStore('periodstore1');
        var period1 = this.lookupReference('period1');
        var period2 = this.lookupReference('period2');
        if (newValue) {
            period1.lastQuery = null;
            period1.setValue(null);
            period2.setValue(null);
            store.proxy.extraParams = { repCd: 'RptPayDocList', tp: 1};
            period2.hide();
        } else {
            period1.lastQuery = null;
            period1.setValue(null);
            period2.setValue(null);
            store.proxy.extraParams = {repCd: 'RptPayDocList',  tp: 0};
            period2.show();
        }
    },
    // Печать отчета платежек
    onPrintClick: function () {
        console.log('onPrintClick');
        var period1 = this.lookupReference('period1');
        console.log('period1='+period1.getValue());
        window.location.assign('/rep/payordFlow1?periodId='+period1.getValue());
    }

});

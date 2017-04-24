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
        //alert('id1:'+this.getViewModel().get('periodId1'));
        //alert('id2:'+this.getViewModel().get('periodId2'));

        var store = this.getViewModel().getStore('periodstore1');
        if (newValue) {
            store.load({params: {'tp': 1}});
        } else {
            store.load({params: {'tp': 0}});
        }

        var store = this.getViewModel().getStore('periodstore2');
        if (newValue) {
            store.load({params: {'tp': 1}});
        } else {
            store.load({params: {'tp': 0}});
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

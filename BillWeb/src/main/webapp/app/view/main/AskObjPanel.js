Ext.define('BillWebApp.view.main.AskObjPanel', {
    extend: 'Ext.tab.Panel',
    xtype: 'askobjpanel',
    alias: 'widget.askobjpanel',

    modal: true,
    width: 500,
    height: 400,
    title: 'Foo',
    floating: true,
    closable : true,

    controller: 'main', // Обязательно указывать контроллер, иначе не будет привязан нужный store!!!

    buttons: [{
        text: 'Ok'
    }]
});
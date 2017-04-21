var askObjPanel;
Ext.define('BillWebApp.view.main.Panel4Controller', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.panel4controller',

    // Формирование платежки
    onGenClick: function () {
        var genDt = this.lookupReference('genDt');
        console.log("onGenClick="+Ext.Date.format(genDt.getValue(), 'd.m.Y'));
        Ext.Ajax.request({
            url: '/genPayord',
            success: function (response) {
                alert("Платежки на заданную дату сформированы!");
            },
            params :{
                genDt: Ext.Date.format(genDt.getValue(), 'd.m.Y'),
                isFinal: false,
                isEndMonth: false
            },
            method : 'POST'
        });

    }});

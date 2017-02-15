Ext.define('BillWebApp.view.main.Panel2', {
    extend: 'Ext.tab.Panel',
    xtype: 'panel2',

    title: 'Настройка платежек',
    width: 700,
    height: 400,
    minWidth: 800,
    minHeight: 600,
    layout: 'fit',
    plain: true,

    items: [{
        xtype: 'form',

        defaultType: 'textfield',
        layout: {
            type: 'vbox',
            align: 'stretch'
        },

        bodyPadding: 5,
        border: false,

        items: [{
            xtype: 'grid1'
        }]
    }]
});
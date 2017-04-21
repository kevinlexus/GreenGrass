Ext.define('BillWebApp.view.main.Panel4', {
    extend: 'Ext.panel.Panel',
    xtype: 'panel4',
    title: 'Формирование платежек',
    layout: {
        type: 'hbox'
    },
    width: 500,
    minHeight: 300,
    bodyPadding: 10,
    reference: 'panel4',
    controller: 'panel4controller',
    frame: true,
    items: [{
        xtype: 'datefield',
        name: 'genDt',
        reference: 'genDt',
        fieldLabel: 'Дата формирования',
        margin: '0 5 0 0',
        allowBlank: false,
        format: 'd.m.Y'
        }
    ],

    buttons: [{
        text   : 'Сформировать',
        handler: 'onGenClick'
    }]

});


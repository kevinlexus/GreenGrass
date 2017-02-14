Ext.define('BillWebApp.view.main.Panel1', {
    extend: 'Ext.tab.Panel',
    xtype: 'panel1',

    title: 'Печать платежек',
    width: 700,
    height: 400,
    minWidth: 700,
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

        items: [
            {
                // блок выбора периода
                xtype: 'fieldset',
                title: 'Период',
                defaultType: 'textfield',
                layout: {
                    type: 'vbox',
                    align: 'stretch'
                },
                defaults: {
                    anchor: '100%'
                },
                items: [
                    {
                        xtype: 'combobox',
                        fieldLabel: 'С',
                        displayField: 'period',
                        valueField: 'id',
                        bind: {
                            store: '{periodstore1}',
                            value: '{periodId1}'
                        }
                    },
                    {
                        xtype: 'combobox',
                        fieldLabel: 'По',
                        displayField: 'period',
                        valueField: 'id',
                        bind: {
                            store: '{periodstore2}',
                            value: '{periodId2}'
                        }
                    }, {
                        xtype: 'checkboxfield',
                        name: 'checkbox1',
                        fieldLabel: 'Текущие',
                        listeners: {
                            change: 'onChangePeriodType'
                        }

/*
listeners: {
    checkchange: 'checkTest'
}*/

                    }
                ]
            },
            {
                // блок выбора параметров
                xtype: 'fieldset',
                title: 'Параметры',
                defaultType: 'textfield',
                layout: {
                    type: 'vbox',
                    align: 'stretch'
                },
                items: [
                    {
                        xtype: 'combobox',
                        reference: 'states',
                        publishes: 'value',
                        fieldLabel: 'Организация',
                        displayField: 'state'
                    },
                    {
                        xtype: 'combobox',
                        reference: 'states',
                        publishes: 'value',
                        fieldLabel: 'УК',
                        displayField: 'state'
                    }, {
                        xtype: 'checkboxfield',
                        name: 'checkbox1',
                        boxLabel: 'Детализация по платежкам'
                    }, {
                        xtype: 'checkboxfield',
                        name: 'checkbox1',
                        boxLabel: 'Группировать'
                    }
                ]
            }]
    }],

    buttons: [{
        text: 'Получить отчет'
    }]
});
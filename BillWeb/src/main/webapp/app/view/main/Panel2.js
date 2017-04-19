Ext.define('BillWebApp.view.main.Panel2', {
    extend: 'Ext.panel.Panel',
    xtype: 'panel2',
    title: 'Редактирование платежек',
    layout: {
        type: 'vbox' // после смены vbox, проверить, как открываются комбо-боксы (могут не работать)
    },
    width: 1200,
    minHeight: 500,
    bodyPadding: 10,
    reference: 'panel2',
    //controller: 'panel2controller',
    defaults: {
        frame: true,
        bodyPadding: 10
    },

    items: [{
            // Платежные поручения в банк
            xtype: 'gridpanel',
            reference: 'payordFlowGrid',
            width: 1200,
            minHeight: 120,
            margin: '0 0 10 0',
            /*tbar: [{
                text: 'Добавить группу',
                handler: 'onGridPayordGrpAdd'
            }, {
                text: 'Сохранить',
                handler: 'onGridPayordGrpUpd'
            }, {
                text: 'Отменить',
                handler: 'onGridPayordGrpCancel'
            }],*/
            requires: [
                'Ext.selection.CellModel',
                'Ext.grid.column.Action'
            ],
            plugins: {
                ptype: 'cellediting',
                clicksToEdit: 1
            },
            bind: {
                store: '{payordflowstore}',
                listeners: {
                   // edit: 'onGridPayordGrpUpd',
                   // cancelEdit: 'onGridPayordGrpCancel'
                }
            },
            actions: {
                del: {
                    glyph: 'xf147@FontAwesome',
                    tooltip: 'Удалить',
                    handler: 'onGridPayordGrpDel'
                }
            },
            /*listeners: {
                // клик по строчке группы платежки, отобразить в дочернем гриде формулы
                rowclick: 'onGridPayordGrpRowClick'
            },*/
            columns: [
                { text: 'Id',  dataIndex: 'id', width: 50,
                    editor: {
                        allowBlank: true
                    }
                },
                { text: 'Сумма к перечисл.',  dataIndex: 'summa1', width: 150,
                    editor: {
                        allowBlank: true
                    }
                },
                { text: '№ п.п.',  dataIndex: 'npp', width: 100,
                    editor: {
                        allowBlank: true
                    }
                },
                { text: 'Расчет.сумма',  dataIndex: 'summa6', width: 150,
                    editor: {
                        allowBlank: true
                    }
                },
                 {
                    menuDisabled: true,
                    sortable: false,
                    xtype: 'actioncolumn',
                    width: 50,
                    items: ['@del']
                }
            ]
        }]

});

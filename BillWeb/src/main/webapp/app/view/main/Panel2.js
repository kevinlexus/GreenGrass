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
    controller: 'panel2controller',
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
            tbar: [{
                text: 'Добавить платежку',
                handler: 'onGridPayordFlowAdd'
            }, {
                text: 'Сохранить',
                handler: 'onGridPayordFlowUpd'
            }, {
                text: 'Отменить',
                handler: 'onGridPayordFlowCancel'
            }],
            requires: [
                'Ext.selection.CellModel',
                'Ext.grid.column.Action'
            ],
            plugins: {
                ptype: 'cellediting',
                clicksToEdit: 1,
                listeners: {
                    beforeedit: function(editor, context, eOpts){
                        // workaround for error at clicking a widgetcolumn
                        if (context.column.widget)
                            return false;
                    }
                }
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
                    handler: 'onGridPayordFlowDel'
                }
            },
            listeners: {            },
            columns: [
                { text: 'Id',  dataIndex: 'id', width: 50,
                    editor: {
                        allowBlank: true
                    }
                },
                {
                    text: 'Платежка',
                    dataIndex: 'payordFk',
                    width: 200, align: "left",
                    queryMode: 'local',
                    editor: {
                        xtype: 'combo',
                        typeAhead: true,
                        forceSelection: true,
                        displayField: 'name',
                        valueField: 'id',
                        triggerAction: 'all',
                        validator: function(value) {
                            if (value != '') {
                                return true;
                            } else {
                                return 'Необходимо заполнить поле!';
                            }
                        },
                        bind: {
                            store: '{payordstore}'
                        },
                        allowBlank: false
                    }//,
                    //renderer: 'onGridPayordFlowPayordRender'
                },
                { text: 'Сумма к перечисл.',  dataIndex: 'summa', width: 150,
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
                { xtype: 'checkcolumn', text: 'Active', dataIndex: 'signed' }
                ,
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

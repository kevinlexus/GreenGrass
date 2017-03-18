Ext.define('BillWebApp.view.main.Panel3', {
    extend: 'Ext.panel.Panel',
    xtype: 'panel3',
    title: 'Настройки платежек',
    layout: {
        type: 'vbox',
        align: 'stretch'
    },
    width: 1200,
    height: 300,
    minWidth: 1000,
    minHeight: 800,
    bodyPadding: 10,
    viewModel: {
        type: 'main'
    },

    controller: 'main', // Обязательно указывать контроллер, иначе не будет привязан нужный store!!!

    defaults: {
        frame: true,
        bodyPadding: 10
    },

    items: [
                {
            // ГРУППЫ ПЛАТЕЖЕК
            xtype: 'gridpanel',
            controller: 'main', // Обязательно указывать контроллер, иначе не будет привязан нужный store!!!

            requires: [
                'Ext.selection.CellModel',
                'Ext.grid.column.Action'
            ],
            width: 1200,
            height: 300,
            margin: '0 0 10 0',

            autoLoad: true,
            frame: true,
            selModel: {
                type: 'cellmodel'
            },
            tbar: [{
                text: 'Добавить группу',
                handler: 'onGridPayordGrpAdd'
            }],
            plugins: {
                ptype: 'cellediting',
                clicksToEdit: 1,
                //listeners: { edit: function(editor, e){console.log('gggggggggggggggggg')} }
                //listeners: { edit: 'onGridPayordGrpEdit'
                //            }
            },
            bind: {
                store: '{payordgrpstore}'
            },
            listeners: {
                // клик по строчке платежки, отобразить в дочернем гриде формулы
                rowclick: 'onGridPayordGrpRowClick'
            },
            actions: {
                del: {
                    glyph: 'xf147@FontAwesome',
                    tooltip: 'Удалить',
                    handler: 'onGridPayordGrpDel'
                }
            },
            columns: [
                { text: 'Id',  dataIndex: 'id', width: 50,
                    editor: {
                        allowBlank: true
                    }
                },
                { text: 'Наименование',  dataIndex: 'name', width: 400,
                    editor: {
                        allowBlank: false
                    }
                }/*,
                { text: 'Создано',  dataIndex: 'dtf', width: 170,
                    formatter: 'date("d-m-Y H:i:s")'
                },
                { text: 'Пользователь',  dataIndex: 'username', width: 150
                },
                 {
                    menuDisabled: true,
                    sortable: false,
                    xtype: 'actioncolumn',
                    width: 50,
                    items: ['@del']
                }*/
            ]
        },
        {
        // ПЛАТЕЖКИ
        xtype: 'gridpanel',
        iconCls: 'framing-buttons-grid',
        reference: 'payordGrid',

        width: 1000,
        margin: '0 0 10 0',
        header: false,
        layout: 'fit',

        requires: [
            'Ext.selection.CellModel'
        ],
        plugins: {
            ptype: 'cellediting',
            clicksToEdit: 1
        },

        autoLoad: true,
        frame: true,
        selModel: {
            type: 'cellmodel'
        },
        bind: {
            store: '{payordstore}'
        },
        listeners: {
            // клик по строчке платежки, отобразить в дочернем гриде формулы
            rowclick: 'onGridPayordClick'
        },
        columns: [
            { text: 'Id',  dataIndex: 'id', width: 50
            },
            { text: 'Наименование',  dataIndex: 'name', width: 400,
                editor: {
                    allowBlank: false
                }
            },
            {
                header: 'Периодичность',
                dataIndex: 'periodTpFk',
                width: 170,
                editor: {
                    xtype: 'combo',
                    typeAhead: true,
                    forceSelection: true,
                    displayField: 'name',
                    valueField: 'id',
                    triggerAction: 'all',
                    bind: {
                        store: '{lststore}'
                    }
                },
                  renderer: 'onGridPayordPeriodRender'
            },
            { text: 'Дни формир.',  dataIndex: 'selDays', width: 100,
                editor: {
                    allowBlank: true
                }
            },
            { text: 'Формула',  dataIndex: 'formula', width: 100,
                editor: {
                    allowBlank: true
                }
            }
            ,
            { text: 'Сумма',  dataIndex: 'summa', width: 100
            },
            { text: 'Создано',  dataIndex: 'dtf', width: 170,
                formatter: 'date("d-m-Y H:i:s")'
            },
            { text: 'Пользователь',  dataIndex: 'username', width: 150
            }
        ]
    },
        {
            // ФОРМУЛЫ ПЛАТЕЖЕК
            xtype: 'gridpanel',
            iconCls: 'framing-buttons-grid',
            reference: 'payordCmpGrid',

            width: 1000,
            margin: '0 0 10 0',
            header: false,
            requires: [
                'Ext.selection.CellModel'
            ],
            plugins: {
                ptype: 'cellediting',
                clicksToEdit: 1
            },

            autoLoad: true,
            frame: true,
            selModel: {
                type: 'cellmodel'
            },

            bind: {
                store: '{payordcmpstore}',
            },
            columns: [
                { text: 'Id',  dataIndex: 'id', width: 50
                },
                {
                    header: 'Вар.сбора',
                    dataIndex: 'varFk',
                    width: 200,
                    editor: {
                        xtype: 'combo',
                        typeAhead: true,
                        forceSelection: true,
                        displayField: 'name',
                        valueField: 'id',
                        triggerAction: 'all',
                        bind: {
                            store: '{varstore}'
                        }
                    },
                    renderer: 'onGridPayordCmpVarRender'
                },
                {
                    header: 'Услуга',
                    dataIndex: 'servFk',
                    width: 200,
                    editor: {
                        xtype: 'combo',
                        typeAhead: true,
                        forceSelection: true,
                        displayField: 'name',
                        valueField: 'id',
                        triggerAction: 'all',
                        bind: {
                            store: '{servstore}'
                        }
                    },
                    renderer: 'onGridPayordCmpServRender'
                },
                {
                    header: 'Организация',
                    dataIndex: 'orgFk',
                    width: 200,
                    editor: {
                        xtype: 'combo',
                        typeAhead: true,
                        forceSelection: true,
                        displayField: 'name',
                        valueField: 'id',
                        triggerAction: 'all',
                        bind: {
                            store: '{orgstore}'
                        }
                    },
                    renderer: 'onGridPayordCmpOrgRender'
                },

                { text: 'Маркер',  dataIndex: 'mark', width: 150
                },
                { text: 'Сумма',  dataIndex: 'summa', width: 150
                },
                { text: 'Создано',  dataIndex: 'dtf', width: 170,
                    formatter: 'date("d-m-Y H:i:s")'
                },
                { text: 'Пользователь',  dataIndex: 'username', width: 150
                }
            ]
        }

    ]

});

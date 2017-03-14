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

    defaults: {
        frame: true,
        bodyPadding: 10
    },

    items: [
        {

            xtype: 'gridpanel',
            iconCls: 'framing-buttons-grid',

            width: 1200,
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
                store: '{payordgrpstore}'
            },
            //store: { type: 'payordgrpstore' },
            listeners: {
                // клик по строчке платежки, отобразить в дочернем гриде формулы
                rowclick: function(grid, rec) {
                    var viewModel = this.lookupViewModel();
                    var store1 = viewModel.getStore('payordstore');
                    store1.load({
                        params : {
                            'payordGrpId': rec.get('id')
                        }
                    });

                    /* вызвается асинхронно var rec2 = store1.getAt(0);
                    var store2 = viewModel.getStore('payordcmpstore');
                    console.log("ID="+rec2.get('id'))
                    store2.load({
                        params : {
                            'payordId': rec2.get('id')
                        }
                    });*/

                }
            },

            columns: [
                { text: 'Id',  dataIndex: 'id', width: 50,
                    editor: {
                        readOnly:true //только для чтения
                    }
                },
                { text: 'Наименование',  dataIndex: 'name', width: 400,
                    editor: {
                        allowBlank: false
                    }
                },
                { text: 'Создано',  dataIndex: 'dtf', width: 170,
                    formatter: 'date("d-m-Y H:i:s")',
                    editor: {
                        readOnly:true, //только для чтения
                        allowBlank: false
                    }
                },
                { text: 'Пользователь',  dataIndex: 'username', width: 150,
                    editor: {
                        readOnly:true //только для чтения
                    }
                }]



        },
        {
        xtype: 'gridpanel',
        iconCls: 'framing-buttons-grid',

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
            rowclick: function(grid, rec) {
                var viewModel = this.lookupViewModel();
                var store = viewModel.getStore('payordcmpstore');
                store.load({
                    params : {
                        'payordId': rec.get('id')
                    }
                });
            }
        },
        columns: [
            { text: 'Id',  dataIndex: 'id', width: 50,
                editor: {
                    readOnly:true //только для чтения
                }
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

                renderer: function (value, metaData, record, rowIndex, colIndex, store, view) {
                    var store = Ext.getStore('LstStore');
                    var index = store.findExact('id', value);
                    //console.log('value:'+value);
                    //console.log('index:'+index);
                    if (index != -1){
                        var rs = store.getAt(index);
                        console.log('rs.display:'+rs.get('name'));
                        return rs.get('name');
                    }
                }
            },
            { text: 'Дни формир.',  dataIndex: 'selDays', width: 150,
                editor: {
                    allowBlank: true
                }
            },
            { text: 'Создано',  dataIndex: 'dtf', width: 170,
                formatter: 'date("d-m-Y H:i:s")',
                editor: {
                    readOnly:true, //только для чтения
                    allowBlank: false
                }
            },
            { text: 'Пользователь',  dataIndex: 'username', width: 150,
                editor: {
                    readOnly:true //только для чтения
                }
            }

        ]
    },
        {
            xtype: 'gridpanel',
            iconCls: 'framing-buttons-grid',

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
                store: '{payordcmpstore}',
            },
            columns: [
                { text: 'Id',  dataIndex: 'id', width: 50,
                    editor: {
                        readOnly:true //только для чтения
                    }
                },
                { text: 'Создано',  dataIndex: 'dtf', width: 170,
                    formatter: 'date("d-m-Y H:i:s")',
                    editor: {
                        readOnly:true, //только для чтения
                        allowBlank: false
                    }
                },
                { text: 'Пользователь',  dataIndex: 'username', width: 150,
                    editor: {
                        readOnly:true //только для чтения
                    }
                }

            ]
        }

    ]

});

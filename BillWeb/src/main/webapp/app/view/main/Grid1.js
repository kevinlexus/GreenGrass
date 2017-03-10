Ext.define('BillWebApp.view.main.Grid1', {
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
            store: { type: 'payordgrpstore' },

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


        store: { type: 'payordstore' },

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
                    console.log('value:'+value);
                    console.log('index:'+index);
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

    }
    ]

});

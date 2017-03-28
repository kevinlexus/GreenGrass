Ext.define('BillWebApp.view.main.Panel3', {
    extend: 'Ext.panel.Panel',
    xtype: 'panel3',
    title: 'Настройки платежек',
    layout: {
        type: 'vbox',
        align: 'stretch'
    },
    width: 1200,
    minHeight: 300,
    bodyPadding: 10,
    viewModel: {
        type: 'main'
    },

    referenceHolder: true, // Важно! Эта панель является держателем ссылок (reference)
                           // и поэтому в контроллере можно будет искать по lookupReference

    controller: 'main', // Обязательно указывать контроллер, иначе не будет привязан нужный store!!!

    defaults: {
        frame: true,
        bodyPadding: 10
    },

    items: [
            {
            // ГРУППЫ ПЛАТЕЖЕК
            xtype: 'gridpanel',
            reference: 'payordGrpGrid',
            width: 1200,
            minHeight: 220,
            margin: '0 0 10 0',
            tbar: [{
                text: 'Добавить группу',
                handler: 'onGridPayordGrpAdd'
            }],
            requires: [
                'Ext.selection.CellModel',
                'Ext.grid.column.Action'
            ],
            selModel: 'cellmodel',
            plugins: {
                ptype: 'rowediting',
                clicksToEdit: 2,
                saveBtnText: 'Сохранить',
                cancelBtnText: 'Отмена',
                errorSummary: false // погасить сообщение валидации
            },
            bind: {
                store: '{payordgrpstore}',
                listeners: {
                    edit: 'onGridPayordGrpUpd',
                    cancelEdit: 'onGridPayordGrpCancel'
                }
            },
            actions: {
                del: {
                    glyph: 'xf147@FontAwesome',
                    tooltip: 'Удалить',
                    handler: 'onGridPayordGrpDel'
                }
            },
            listeners: {
                // клик по строчке группы платежки, отобразить в дочернем гриде формулы
                rowclick: 'onGridPayordGrpRowClick'
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
                },
                { text: 'Создано',  dataIndex: 'dtf', width: 100,
                    formatter: 'date("d-m-Y H:i:s")'
                },
                { text: 'Пользователь',  dataIndex: 'username', width: 100
                },
                 {
                    menuDisabled: true,
                    sortable: false,
                    xtype: 'actioncolumn',
                    width: 50,
                    items: ['@del']
                }
            ]
        },
        {
        // ПЛАТЕЖКИ
        xtype: 'gridpanel',
        iconCls: 'framing-buttons-grid',
        reference: 'payordGrid',
        width: 1000,
        minHeight: 220,
        header: false,
        margin: '0 0 10 0',
        tbar: [{
            text: 'Добавить платежку',
            handler: 'onGridPayordAdd'
        }],
        requires: [
            'Ext.selection.CellModel',
            'Ext.grid.column.Action'
        ],
        selModel: 'cellmodel',
        plugins: {
            ptype: 'rowediting',
            clicksToEdit: 2,
            saveBtnText: 'Сохранить',
            cancelBtnText: 'Отмена',
            errorSummary: false // погасить сообщение валидации
        },
        bind: {
            store: '{payordstore}',
            listeners: {
                edit: 'onGridPayordUpd',
                cancelEdit: 'onGridPayordCancel'
            }
        },
        actions: {
            del: {
                glyph: 'xf147@FontAwesome',
                tooltip: 'Удалить',
                handler: 'onGridPayordDel'
            }
        },
        listeners: {
            // клик по строчке платежки, отобразить в дочернем гриде формулы
            rowclick: 'onGridPayordRowClick'
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
                text: 'Периодичность',
                dataIndex: 'periodTpFk',
                width: 170,
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
                        store: '{lststore}'
                    },
                    allowBlank: false
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
            { text: 'Сумма',  dataIndex: 'summa', width: 70
            },
            { text: 'Создано',  dataIndex: 'dtf', width: 100,
                formatter: 'date("d-m-Y H:i:s")'
            },
            { text: 'Пользователь',  dataIndex: 'username', width: 100
            },
            {
                menuDisabled: true,
                sortable: false,
                xtype: 'actioncolumn',
                width: 50,
                items: ['@del']
            }
        ]
    },
        {
            // ФОРМУЛЫ ПЛАТЕЖЕК
            xtype: 'gridpanel',
            iconCls: 'framing-buttons-grid',
            reference: 'payordCmpGrid',

            width: 1000,
            minHeight: 220,
            header: false,

            margin: '0 0 10 0',
            tbar: [{
                text: 'Добавить формулу',
                handler: 'onGridPayordCmpAdd'
            }],
            requires: [
                'Ext.selection.CellModel',
                'Ext.grid.column.Action'
            ],
            selModel: 'cellmodel',
            plugins: {
                ptype: 'rowediting',
                clicksToEdit: 2,
                saveBtnText: 'Сохранить',
                cancelBtnText: 'Отмена',
                errorSummary: false // погасить сообщение валидации
            },
            bind: {
                store: '{payordcmpstore}',
                listeners: {
                    edit: 'onGridPayordCmpUpd',
                    cancelEdit: 'onGridPayordCmpCancel'
                }
            },
            actions: {
                del: {
                    glyph: 'xf147@FontAwesome',
                    tooltip: 'Удалить',
                    handler: 'onGridPayordCmpDel'
                }
            },
            listeners: {
                itemdblclick: 'onGridPayordCmpItemDblClick'
            },
            columns: [
                { text: 'Id',  dataIndex: 'id', width: 50
                },
                {
                    header: 'Вар.сбора',
                    dataIndex: 'varFk',
                    width: 200,
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
                            store: '{varstore}'
                        },
                        allowBlank: false
                    }
                },
                {
                    header: 'Услуга',
                    dataIndex: 'servFk',
                    width: 200,
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
                            store: '{servstore}'
                        },
                        allowBlank: false
                    },
                    renderer: 'onGridPayordCmpServRender'
                },
                {
                    header: 'Организация',
                    dataIndex: 'orgFk',
                    width: 200,
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
                            store: '{orgstore}'
                        },
                        allowBlank: false
                    },
                    renderer: 'onGridPayordCmpOrgRender'
                },
                {
                    header: 'Тип объекта',
                    dataIndex: 'areaFk',
                    width: 200,
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
                            store: '{areastore}'
                        },
                        allowBlank: false
                    },
                    renderer: 'onGridPayordCmpAreaRender'
                },
                { text: 'KlskFk',  dataIndex: 'klskFk', width: 150
                },
                { text: 'Маркер',  dataIndex: 'mark', width: 150
                },
                { text: 'Сумма',  dataIndex: 'summa', width: 70
                },
                { text: 'Создано',  dataIndex: 'dtf', width: 100,
                    formatter: 'date("d-m-Y H:i:s")'
                },
                { text: 'Пользователь',  dataIndex: 'username', width: 100
                },
                {
                    menuDisabled: true,
                    sortable: false,
                    xtype: 'actioncolumn',
                    width: 50,
                    items: ['@del']
                }
            ]
        }

    ]

});

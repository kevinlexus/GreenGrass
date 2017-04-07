Ext.define('BillWebApp.view.main.Panel3', {
    extend: 'Ext.panel.Panel',
    xtype: 'panel3',
    title: 'Настройки платежек',
    layout: {
        type: 'vbox' // после смены vbox, проверить, как открываются комбо-боксы (могут не работать)
    },
    width: 1200,
    minHeight: 500,
    bodyPadding: 10,
    reference: 'panel3',
    controller: 'panel3controller',
    defaults: {
        frame: true,
        bodyPadding: 10
    },

    items: [{
            // ГРУППЫ ПЛАТЕЖЕК
            xtype: 'gridpanel',
            reference: 'payordGrpGrid',
            width: 1200,
            minHeight: 120,
            margin: '0 0 10 0',
            tbar: [{
                text: 'Добавить группу',
                handler: 'onGridPayordGrpAdd'
            }, {
                text: 'Сохранить',
                handler: 'onGridPayordGrpUpd'
            }],
            requires: [
                'Ext.selection.CellModel',
                'Ext.grid.column.Action'
            ],
            plugins: {
                ptype: 'cellediting',
                clicksToEdit: 1
            },
            //selModel: 'cellmodel',
            /*plugins: {
                ptype: 'rowediting',
                clicksToEdit: 2,
                saveBtnText: 'Сохранить',
                cancelBtnText: 'Отмена',
                errorSummary: false // погасить сообщение валидации
            },*/
            bind: {
                store: '{payordgrpstore}',
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
                { text: 'Наименование',  dataIndex: 'name', width: 400, align: "left",
                    editor: {
                        allowBlank: false
                    }
                },
                { text: 'Создано',  dataIndex: 'dtf', width: 100, align: "left",
                    formatter: 'date("d-m-Y H:i:s")'
                },
                { text: 'Пользователь',  dataIndex: 'username', width: 100, align: "left"
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
        //selModel: 'cellmodel',
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
            { text: 'Наименование',  dataIndex: 'name', width: 400, align: "left",
                editor: {
                    allowBlank: false
                }
            },
            {
                text: 'Периодичность',
                dataIndex: 'periodTpFk',
                width: 170, align: "left",
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

            { text: 'Дни формир.',  dataIndex: 'selDays', width: 100, align: "left",
                editor: {
                    allowBlank: true
                }
            },
            { text: 'Формула',  dataIndex: 'formula', width: 100, align: "left",
                editor: {
                    allowBlank: true
                }
            }
            ,
            { text: 'Сумма',  dataIndex: 'summa', width: 70, align: "left"
            },
            { text: 'Создано',  dataIndex: 'dtf', width: 100, align: "left",
                formatter: 'date("d-m-Y H:i:s")'
            },
            { text: 'Пользователь',  dataIndex: 'username', width: 100, align: "left"
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
            }, {
                text: 'Сохранить',
                handler: 'onGridPayordCmpUpd'
            }, {
                text: 'Отменить',
                handler: 'onGridPayordCmpCancel'
            }],
            requires: [
                'Ext.selection.CellModel',
                'Ext.grid.column.Action'
            ],
            //selModel: 'cellmodel',
            plugins: {
                ptype: 'cellediting',
                clicksToEdit: 1
            }/*,
            plugins: {
                ptype: 'rowediting',
                clicksToEdit: 2,
                saveBtnText: 'Сохранить',
                cancelBtnText: 'Отмена',
                errorSummary: false // погасить сообщение валидации
            }*/,
            bind: {
                store: '{payordcmpstore}',
                listeners: {
                    //edit: 'onGridPayordCmpUpd',
                    //cancelEdit: 'onGridPayordCmpCancel'
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
              //  itemdblclick: 'onGridPayordCmpItemSel'
             //   load: 'onGridPayordCmpItemDblClick'
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
                    },
                    renderer: 'onGridPayordCmpVarRender'
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
                        allowBlank: false,
                        bind: {
                            store: '{orgstore}'
                        }
                    },
                    renderer: 'onGridPayordCmpOrgRender'
                },
                {
                    header: 'koFk',
                    dataIndex: 'koFk',
                    width: 0// 0 - чтобы не было видно поле, а поле нужно, иначе не отработает сохранение в store (жесть)
                },
                {
                    header: 'Объект',
                    dataIndex: 'koName',
                    width: 200,
                    queryMode: 'local',
                    editor: {
                        xtype: 'combo',
                        typeAhead: true,
                        forceSelection: true,
                        triggerAction: 'all',
                        allowBlank: true,
                        listeners: {
                            expand: 'onGridPayordCmpItemSel'
                        }
                    }
                },
                { text: 'Маркер',  dataIndex: 'mark', width: 50, align: "left",
                    editor: {
                        allowBlank: true
                    }
                },
                { text: 'Сумма',  dataIndex: 'summa', width: 70, align: "left"
                },
                { text: 'Создано',  dataIndex: 'dtf', width: 100, align: "left",
                    formatter: 'date("d-m-Y H:i:s")'
                },
                { text: 'Пользователь',  dataIndex: 'username', width: 100, align: "left"
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

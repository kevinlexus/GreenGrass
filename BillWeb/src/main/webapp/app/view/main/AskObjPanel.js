Ext.define('BillWebApp.view.main.AskObjPanel', {


    extend: 'Ext.form.Panel',
    xtype: 'form-hboxlayout',
    alias: 'widget.askobjpanel',
    width: 500,
    height: 300,
    minWidth: 300,
    minHeight: 220,
    layout: 'form',
    plain: true,
    //bodyPadding: 10,
    //frame: true,
    resizable : true,

//    viewModel: { - надо или нет?
//        type: 'main'
//    },

    dockedItems: [{
        xtype: 'toolbar',
        flex: 1,
        dock: 'bottom',
        ui: 'footer',
        layout: {
            pack: 'end',
            type: 'hbox'
        },
        items: ['->', {
            xtype: 'button',
            text: 'Выбрать'
        }]
    }],

    items: [{
        xtype: 'fieldset',
        defaultType: 'textfield',
        layout: 'anchor',
        items: [
            {   xtype: 'combo',
                typeAhead: true,
                forceSelection: true,
                fieldLabel: 'Тип',
                labelWidth: 30,
                displayField: 'name',
                valueField: 'id',
                triggerAction: 'all',
                bind: {
                    store: '{addrtpspecstore}'
                }
            },
            {
                xtype: 'fieldcontainer',
                layout: 'hbox',
                align: 'stretch',
                combineErrors: true,

                items: [{
                    xtype: 'textfield',
                    name: 'objName',
                    flex: 8,
                    emptyText: 'Введите наименование',
                    allowBlank: false
                }, {
                    flex: 2,
                    xtype: 'button',
                    text: 'Найти'
                }]
            },
            {
            xtype: 'container',
            layout: 'hbox',
            defaultType: 'textfield',

            items: [

                {
                    // ГРУППЫ ПЛАТЕЖЕК
                    xtype: 'gridpanel',
                    reference: 'payordGrpGrid',
                    selModel: 'cellmodel',
                    flex: 1,
                    height: 170,
                    hideHeaders: true,
                    bind: {
                        store: '{payordgrpstore}',
                        listeners: {
                            edit: 'onGridPayordGrpUpd',
                            cancelEdit: 'onGridPayordGrpCancel'
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
                        }
                    ]
                }

            ]
        }]
    }]/*,
        {
            xtype: 'container',
            layout: {
                type: 'hbox'
            },
            dock: 'bottom',
            items:[{
                xtype: 'button',
                text: 'blabla'
            }]
        }

    ]*/

/*    items: [{
        xtype: 'form',

        fieldDefaults: {
            labelWidth: 60
        },

        layout: 'anchor',
        defaults: {
            anchor: '100%'
        },
        items: [{
            xtype: 'textfield',
            fieldLabel: 'Send To',
            name: 'to',
            flex: 2
        }, {
            xtype: 'button',
            text: 'Поиск',
            flex: 3
        }, {
            // ГРУППЫ ПЛАТЕЖЕК
            xtype: 'gridpanel',
            reference: 'payordGrpGrid',
            width: 600,
            minHeight: 220,
            flex: 1,
            margin: '0 0 10 0',
            selModel: 'cellmodel',
            bind: {
                store: '{payordgrpstore}',
                listeners: {
                    edit: 'onGridPayordGrpUpd',
                    cancelEdit: 'onGridPayordGrpCancel'
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
                }
            ]
        }
        ]
    }],

    buttons: [{
        text: 'Send'
    },{
        text: 'Cancel'
    }]
*/

});
Ext.define('BillWebApp.view.main.AskObjPanel', {



    extend: 'Ext.form.Panel',
    xtype: 'form-hboxlayout',

    width: 500,
    height: 300,
    minWidth: 300,
    minHeight: 220,
    layout: 'form',
    plain: true,
    bodyPadding: 10,
    frame: true,
    resizable : true,

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
        defaults: {
            anchor: '100%'
        },
        items: [
            {   xtype: 'combo',
                typeAhead: true,
                forceSelection: true,
                displayField: 'name',
                valueField: 'id',
                triggerAction: 'all',
                bind: {
                    store: '{areastore}'
                }
            },
            {
                xtype: 'fieldcontainer',
                layout: 'hbox',
                combineErrors: true,

                items: [{
                    xtype: 'textfield',
                    labelWidth: 50,
                    //                fieldLabel: 'Объект',
                    name: 'objName',
                    flex: 4,
                    emptyText: 'Введите наименование',
                    allowBlank: false
                }, {
                    xtype: 'button',
                    text: 'Найти'
                }]
            },
            {
            xtype: 'container',
            layout: 'hbox',
            defaultType: 'textfield',
            margin: '0 0 5 0',

            items: [

                {
                    // ГРУППЫ ПЛАТЕЖЕК
                    xtype: 'gridpanel',
                    reference: 'payordGrpGrid',
                    margin: '0 0 10 0',
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
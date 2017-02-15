Ext.define('BillWebApp.view.main.Grid1', {
    extend: 'Ext.grid.Panel',
    xtype: 'grid1',

    title: 'Платежные поручения',
    iconCls: 'framing-buttons-grid',

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
                readOnly:true, //только для чтения
                allowBlank: false
            }
        },
        { text: 'Наименование',  dataIndex: 'name', width: 400,
            editor: {
                allowBlank: false
            }
        },
        { text: 'periodTpFk',  dataIndex: 'periodTpFk', width: 100,
            editor: {
                readOnly:true, //только для чтения
                allowBlank: false
            }
        },{
            header: 'Light',
            dataIndex: 'periodTpFk',
            flex: 1,
            width: 230,
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
                } else {
                    return 'жопа';
                }
                /*if (index != -1){
                    var rs = me.getColumnStoreList("id").getAt(index).data;
                    return rs.value;
                }*/
                /*var index = myStore.findExact('value',val);
                if (index != -1){
                    var rs = myStore.getAt(index).data;
                    return rs.display;
                } else {
                    return 'жопа';
                }*/

            }/*,
            renderer: function(val){
                index = me.getColumnStoreList("id").findExact('key',val);
                if (index != -1){
                    rs = me.getColumnStoreList("id").getAt(index).data;
                    return rs.value;
                }
            }*/
        }

    ],
    height: 300,
    frame: true

});
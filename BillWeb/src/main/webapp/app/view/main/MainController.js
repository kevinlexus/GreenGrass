/**
 * This class is the controller for the main view for the application. It is specified as
 * the "controller" of the Main view class.
 *
 * TODO - Replace this content of this view to suite the needs of your application.
 */
Ext.define('BillWebApp.view.main.MainController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.main',

    // Проверка при включении чекбокса
    onChangePeriodType: function (chk , newValue , oldValue , eOpts) {
        //получить выбранные id
        //alert('id1:'+this.getViewModel().get('periodId1'));
        //alert('id2:'+this.getViewModel().get('periodId2'));

        var store = this.getViewModel().getStore('periodstore1');
        if (newValue) {
            store.load({params: {'tp': 1}});
        } else {
            store.load({params: {'tp': 0}});
        }

        var store = this.getViewModel().getStore('periodstore2');
        if (newValue) {
            store.load({params: {'tp': 1}});
        } else {
            store.load({params: {'tp': 0}});
        }

    },

    // Добавить группу платежек
    onGridPayordGrpAdd: function() {
            rec = new BillWebApp.model.PayordGrp({
                name: 'Заполнить наименование!'
            });
        var store = this.getViewModel().getStore('payordgrpstore');
        store.insert(0, rec);
        var view = this.getView();
        view.findPlugin('cellediting').startEdit(rec, 1);
    },

    onGridPayordGrpEdit: function() {

        var store = this.getViewModel().getStore('payordgrpstore');
        store.load;
        var view = this.getView();
        view.refresh();
    },

    // Удалить группу платежек
    onGridPayordGrpDel: function(grid, rowIndex, colIndex)  {
        Ext.create('Ext.window.MessageBox', {
            multiline: false,
        }).show({
            title: 'Удаление записи',
            msg: 'Вы уверены, удалить группу платежек?',
            closable: false,
            buttons: Ext.Msg.YESNO,
            buttonText: {
                yes: 'Да',
                no: 'Нет'
            },
            fn: function (buttonValue, inputText, showConfig) {
                if (buttonValue == 'yes') {
                    var rec = grid.getStore().getAt(rowIndex);
                    var store = grid.getStore();
                    store.remove(rec);
                }
            },
            icon: Ext.Msg.QUESTION
        });
    },

    onGridPayordGrpRowClick: function(grid, rec) {
        var store = this.getViewModel().getStore('payordstore');
        var store1 = this.getViewModel().getStore('payordcmpstore');
        var payordGrid = this.lookupReference('payordGrid');
        var payordCmpGrid = this.lookupReference('payordCmpGrid');
        store.load({
            params : {
            'payordGrpId': rec.get('id')
            },
            callback: function(records, operation, success) {
                if (success) {
                    payordGrid.getSelectionModel().select(0);
                    payordGrid.getSelectionModel().select(0);
                    payordGrid.getSelectionModel().select(0);
                    var rec1 = records[0];
                    var id = -1;
                    if (records.length > 0) {
                        id =records[0].get('id')
                    }
                        store1.load({
                            params: {
                                'payordId': id
                            },
                            callback: function(records, operation, success) {
                                payordCmpGrid.getSelectionModel().select(0);
                                payordCmpGrid.getSelectionModel().select(0);
                                payordCmpGrid.getSelectionModel().select(0);
                            }
                        });
                } else {
                    console.log('onGridPayordGrpRowClick: NOT SUCCESS');
                }
            }

        });
    },

    // Добавить платежку
    onGridPayordAdd: function() {
        rec = new BillWebApp.model.Payord({
            name: 'Заполнить наименование!'
        });
        var store = this.getViewModel().getStore('payordstore');
        store.insert(0, rec);
        var view = this.getView();
        var plug = view.findPlugin('rowediting')

        console.log('plug:'+plug);
        plug.startEdit(rec, 1);
    },

    // Сохранить отредактированную платежку
    onGridPayordUpd: function() {
        var store = this.getViewModel().getStore('payordstore');
        store.sync;
        console.log('Check Upd')
    },

    onGridPayordClick: function(grid, rec) {
        var store = this.getViewModel().getStore('payordcmpstore');
        var payordCmpGrid = this.lookupReference('payordCmpGrid');
        store.load({
            params : {
                'payordId': rec.get('id')
            },
            callback: function(records, operation, success) {
                payordCmpGrid.getSelectionModel().select(0);

            }
        });
    },

    // выбор периодичности платежки
    onGridPayordPeriodRender: function (value, metaData, record, rowIndex, colIndex, store, view) {
        var store = this.getViewModel().getStore('lststore');
        var index = store.findExact('id', value);
        if (index != -1){
            var rs = store.getAt(index);
            return rs.get('name');
        }
    },

    // выбор варианта сбора формулы платежки
    onGridPayordCmpVarRender: function (value, metaData, record, rowIndex, colIndex, store, view) {
        var store = this.getViewModel().getStore('varstore');
        var index = store.findExact('id', value);
        if (index != -1){
            var rs = store.getAt(index);
            return rs.get('name');
        }
    },

    // выбор услуги формулы платежки
    onGridPayordCmpServRender: function (value, metaData, record, rowIndex, colIndex, store, view) {
        var store = this.getViewModel().getStore('servstore');
        var index = store.findExact('id', value);
        if (index != -1){
            var rs = store.getAt(index);
            return rs.get('name');
        }
    },

    // выбор организации формулы платежки
    onGridPayordCmpOrgRender: function (value, metaData, record, rowIndex, colIndex, store, view) {
        var store = this.getViewModel().getStore('orgstore');
        var index = store.findExact('id', value);
        if (index != -1){
            var rs = store.getAt(index);
            return rs.get('name');
        }
    }
});

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
                    var rec1 = records[0];
                    var id = -1;
                    if (records.length > 0) {
                        id =records[0].get('id')
                        payordGrid.getSelectionModel().select(0); // если включить и будет 0 записей - вызовет model is null
                        // загрузить формулы платежки
                        store1.load({
                            params: {
                                'payordId': id
                            },
                            callback: function(records, operation, success) {
                                if (records.length > 0) {
                                     payordCmpGrid.getSelectionModel().select(0); // если включить и будет 0 записей - вызовет model is null
                                }
                            }
                        });
                    }

                } else {
                    console.log('onGridPayordGrpRowClick: NOT SUCCESS');
                }
            }

        });
    },

    // Добавить группу платежек
    onGridPayordGrpAdd: function() {
        rec = new BillWebApp.model.PayordGrp({
            name: 'Заполнить наименование!'
        });
        var store = this.getViewModel().getStore('payordgrpstore');
        store.insert(0, rec);
        var payordGrpGrid = this.lookupReference('payordGrpGrid');
        payordGrpGrid.findPlugin('cellediting').startEdit(rec, 1);
    },

    // Добавить платежку
    onGridPayordAdd: function() {
        var store = this.getViewModel().getStore('payordstore');
        var grid1 = this.lookupReference('payordGrid');
        //grid1.getSelectionModel().clearSelections();

        console.log('Add2 =');
        /*var rec = new BillWebApp.model.Payord({
         name: 'Заполнить наименование!',
         payordGrpFk : grid.selection.id
         });*/
        var rec = new BillWebApp.model.Payord({
            name: 'Заполнить наименование!',
            payordGrpFk : 2
        });
        console.log('rec='+rec);
        store.insert(0, rec);
        grid1.findPlugin('rowediting').startEdit(rec, 1);
        console.log('Add')
    },

    // Сохранить отредактированную платежку
    onGridPayordUpd: function() {
        var store = this.getViewModel().getStore('payordstore');
        store.sync(); // ВАЖНЫ ПУСТЫЕ СКОБКИ!!! ()
        console.log('Upd')
    },

    // Отменить отредактированную платежку
    onGridPayordCancel: function(rowEditing, context) {
        //var store = this.getViewModel().getStore('payordstore');
        //store.remove(context.record);
        if (context.record.phantom) {
            context.store.remove(context.record);
        }
        console.log('Cancel')
    },

    onGridPayordRowClick: function(grid, rec) {
        var store = this.getViewModel().getStore('payordcmpstore');
        var payordCmpGrid = this.lookupReference('payordCmpGrid');
        console.log('grid2='+payordCmpGrid);
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

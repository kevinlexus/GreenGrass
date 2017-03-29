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
                    store.sync();
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
        payordGrpGrid.findPlugin('rowediting').startEdit(rec, 1);
    },

    // Отменить отредактированную группу платежек
    onGridPayordGrpCancel: function(rowEditing, context) {
        if (context.record.phantom) {
            context.store.remove(context.record);
        }
    },

    // Сохранить отредактированную группу платежек
    onGridPayordGrpUpd: function() {
        var store = this.getViewModel().getStore('payordgrpstore');
        store.sync(); // ВАЖНЫ ПУСТЫЕ СКОБКИ!!! ()
    },

    // Добавить платежку в группу
    onGridPayordAdd: function() {
        var payordstore = this.getViewModel().getStore('payordstore');
        var payordGrpGrid = this.lookupReference('payordGrpGrid');
        var payordGrid = this.lookupReference('payordGrid');
        var rec = new BillWebApp.model.Payord({
            name: 'Заполнить наименование!',
            payordGrpFk : payordGrpGrid.selection.id
        });
        payordstore.insert(0, rec);
        payordGrid.findPlugin('rowediting').startEdit(rec, 1);
    },

    // Удалить платежку
    onGridPayordDel: function(grid, rowIndex, colIndex)  {
        Ext.create('Ext.window.MessageBox', {
            multiline: false,
        }).show({
            title: 'Удаление записи',
            msg: 'Вы уверены, удалить платежку?',
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
                    store.sync();
                }
            },
            icon: Ext.Msg.QUESTION
        });
    },

    // Сохранить отредактированную платежку
    onGridPayordUpd: function() {
        var store = this.getViewModel().getStore('payordstore');
        store.sync(); // ВАЖНЫ ПУСТЫЕ СКОБКИ!!! ()
    },

    // Отменить отредактированную платежку
    onGridPayordCancel: function(rowEditing, context) {
        if (context.record.phantom) {
            context.store.remove(context.record);
        }
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
                if (records.length > 0) {
                    payordCmpGrid.getSelectionModel().select(0);
                }
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

    // Сохранить отредактированную формулу платежки
    onGridPayordCmpUpd: function() {
        var store = this.getViewModel().getStore('payordcmpstore');
        store.sync(); // ВАЖНЫ ПУСТЫЕ СКОБКИ!!! ()
    },

    // Отменить отредактированную формулу платежки
    onGridPayordCmpCancel: function(rowEditing, context) {
        if (context.record.phantom) {
            context.store.remove(context.record);
        }
    },

    // Добавить формулу в платежку
    onGridPayordCmpAdd: function() {
        console.log('Add1');
        var payordcmpstore = this.getViewModel().getStore('payordcmpstore');
        var payordCmpGrid = this.lookupReference('payordCmpGrid');
        var payordGrid = this.lookupReference('payordGrid');
        var rec = new BillWebApp.model.PayordCmp({
            payordFk : payordGrid.selection.id
        });
        payordcmpstore.insert(0, rec);
        payordCmpGrid.findPlugin('rowediting').startEdit(rec, 1);
        console.log('Add2');
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
    },

    // выбор объекта формулы платежки
    onGridPayordCmpAreaRender: function (value, metaData, record, rowIndex, colIndex, store, view) {
        var store = this.getViewModel().getStore('areastore');
        var index = store.findExact('id', value);
        if (index != -1){
            var rs = store.getAt(index);
            return rs.get('name');
        }
    },

    // Удалить формулу платежки
    onGridPayordCmpDel: function(grid, rowIndex, colIndex)  {
        Ext.create('Ext.window.MessageBox', {
            multiline: false,
        }).show({
            title: 'Удаление записи',
            msg: 'Вы уверены, удалить формулу платежки?',
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
                    store.sync();
                }
            },
            icon: Ext.Msg.QUESTION
        });
    },

    onGridPayordCmpItemDblClick: function() {
        console.log("CHECK!!!!!!!!");

        var myForm = new Ext.form.Panel({
            modal: true,
            title: 'Поиск объекта',
            floating: true,
            closable : true,
            items: [
                { xtype: 'askobjpanel' }]
        });
        myForm.show();
    }

});

/**
 * This class is the controller for the main view for the application. It is specified as
 * the "controller" of the Main view class.
 *
 * TODO - Replace this content of this view to suite the needs of your application.
 */
var askObjPanel;
Ext.define('BillWebApp.view.main.Panel3Controller', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.panel3controller',
    listen : {
        controller : {
            '*' : {
                something : 'onSetPayordCmpKlskFk'
            }
        }
    },

    // Событие из контроллера AskObjPanelController
    onSetPayordCmpKlskFk : function(controller, id, name) {
        console.log('id check=', id);

        var payordCmpGrid = this.lookupReference('payordCmpGrid');
        var store = payordCmpGrid.getStore();
        var rec = store.getRange();
        rec[0].set('klskFk', id);
        rec[0].set('koName', name);
        rec[0].commit();  // TODO убрать коммит?
        //store.sync();
        payordCmpGrid.reconfigure(store);

        //var payordCmpGrid = this.lookupReference('payordCmpGrid');
        //var row = payordCmpGrid.getSelectionModel().getSelection()[0];
        //row.set('klskFk', id);

        var panel3 = this.getView();
        panel3.focus();
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
        console.log('onGridPayordGrpRowClick: click!');

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
                        id = records[0].get('id')
                        payordGrid.getSelectionModel().select(0); // если включить и будет 0 записей - вызовет model is null
                    } else {
                        id = -1;
                    }
                    // загрузить формулы платежки
                    console.log('LOAD CMP');
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

        // убрать
        var ppp = this.lookupReference('payordGrpGrid'); // убрать
        console.log('Grid='+ppp);
        var vm = this.getViewModel();
        console.log('View.id='+vm.id);
        console.log('View.type='+vm.type);
        // убрать


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

    // Открыть панель выбора объекта
    onGridPayordCmpItemSel: function() {

        askObjPanel = new Ext.form.Panel({
            modal: true,
            title: 'Поиск объекта',
            floating: true,
            closable : true,
            resizable : true,
            layout: 'fit',

            //viewModel: { //- надо или нет?
            //    type: 'main'
            //},
            //controller: 'main',

            items: [
                { xtype: 'askobjpanel' }
            ]
        });
        askObjPanel.show();

        /*var ppp = this.lookupReference('payordGrpGrid'); // убрать
        console.log('Grid='+ppp);
        var vm = this.getViewModel();
        console.log('View.id='+vm.id);
        console.log('View.type='+vm.type);*/

    }
});

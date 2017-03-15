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

    // может быть удалить эти события:
    onItemSelected: function (sender, record) {
        Ext.Msg.confirm('Confirm', 'Are you sure?', 'onConfirm', this);
    },

    // может быть удалить эти события:
    onConfirm: function (choice) {
        if (choice === 'yes') {
            //
        }
    }
});

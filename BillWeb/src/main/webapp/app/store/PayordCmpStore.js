/**
 * Created by lev on 13.02.2017.
 */
Ext.define('BillWebApp.store.PayordCmpStore', {
    extend: 'Ext.data.Store',
    alias  : 'store.payordcmpstore',
    storeId: 'payordcmpstore',
    model: 'BillWebApp.model.PayordCmp',
    config:{// перенести в модель, если нужно autoSync = false
        autoLoad: false,
        autoSync: false
    }

});
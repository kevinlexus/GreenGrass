/**
 * Created by lev on 18.04.2017.
 */
Ext.define('BillWebApp.store.PayordFlowStore', {
    extend: 'Ext.data.Store',
    alias  : 'store.payordflowstore',
    storeId: 'payordflowstore',
    model: 'BillWebApp.model.PayordFlow',
    config:{// перенести в модель, если нужно autoSync = false
        autoLoad: false,
        autoSync: false
    }

});
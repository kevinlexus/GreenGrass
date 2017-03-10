/**
 * Created by lev on 13.02.2017.
 */
Ext.define('BillWebApp.model.PayordGrp', {
    extend: 'Ext.data.Model',
    fields: [
        { name: 'id', type: 'int', convert: null},
        { name: 'name', type: 'string' },
        { name: 'dtf', dateFormat: 'Y-m-d H:i:s', type: 'date' },
        { name: 'username', type: 'string' }

    ]
});
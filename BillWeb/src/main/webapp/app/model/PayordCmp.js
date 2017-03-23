/**
 * Created by lev on 13.03.2017.
 */
Ext.define('BillWebApp.model.PayordCmp', {
    extend: 'Ext.data.Model',
    fields: [
        { name: 'id', type: 'int', convert: null, persist: false},
        { name: 'dtf', dateFormat: 'Y-m-d H:i:s', type: 'date', persist: false},
        { name: 'username', type: 'string', persist: false},
        { name: 'payordFk', type: 'int', convert: null},
        { name: 'varFk', type: 'int', convert: null},
        { name: 'servFk', type: 'int', convert: null},
        { name: 'orgFk', type: 'int', convert: null},
        { name: 'areaFk', type: 'int', convert: null},
        { name: 'mark', type: 'string' },
        { name: 'summa', type: 'float' }

    ]
});
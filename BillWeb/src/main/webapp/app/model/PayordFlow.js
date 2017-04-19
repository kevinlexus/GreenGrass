/**
 * Created by lev on 18.04.2017.
 */
Ext.define('BillWebApp.model.PayordFlow', {
    extend: 'Ext.data.Model',
    identifier: {
        type: 'sequential',
        id: 'foo'
    },
    idProperty: 'id',
    fields: [
        { name: 'id', mapping: 'id', type: 'int'},
        { name: 'payordFk', type: 'int'},
        { name: 'ukFk', type: 'int'},
        { name: 'summa', type: 'float', persist: true },
        { name: 'summa1', type: 'float', persist: false },
        { name: 'summa2', type: 'float', persist: false },
        { name: 'summa3', type: 'float', persist: false },
        { name: 'summa4', type: 'float', persist: false },
        { name: 'summa5', type: 'float', persist: false },
        { name: 'summa6', type: 'float', persist: false },
        { name: 'npp', type: 'int', persist: true},
        { name: 'dt', dateFormat: 'Y-m-d H:i:s', type: 'date', persist: false},
        { name: 'period', type: 'string', persist: false}],
        proxy: {
            type: 'ajax',
            api: {
            create  : '',
                create  : 'http://192.168.100.21:8083/payord/addPayordFlow',
                read    : 'http://192.168.100.21:8083/payord/getPayordFlowByTpPeriod',
                update  : 'http://192.168.100.21:8083/payord/setPayordFlow',
                destroy : 'http://192.168.100.21:8083/payord/delPayordFlow'
            },
        reader: {
            type: 'json'
        },
        writer: {
            type: 'json',
                allowSingle: false, //запретить по одному отправлять отправлять объекты в Json - только массивом![объект] - иначе трудно описывать в Restful
                writeAllFields: true  //писать весь объект в json
        },
        extraParams : {
            tp : '2',
            period: '201704'
        }
    }
});
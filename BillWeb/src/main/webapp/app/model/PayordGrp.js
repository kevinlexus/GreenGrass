/**
 * Created by lev on 13.02.2017.
 */
Ext.define('BillWebApp.model.PayordGrp', {
    extend: 'Ext.data.Model',
    identifier: {
        type: 'sequential',
        id: 'foo'
    },
    idProperty: 'id',
    fields: [
        { name: 'id', mapping: 'id', type: 'int'},
        { name: 'name', type: 'string' },
        { name: 'dtf', dateFormat: 'Y-m-d H:i:s', type: 'date', persist: false },
        { name: 'username', type: 'string', persist: false }

    ],
    proxy: { // прокси должна находиться в модели. иначе ничего не будет работать при type: 'ajax'
        autoSave: true,
        type: 'ajax',
        api: {
            create  : 'http://192.168.100.21:8083/payord/addPayordGrp',
            read    : 'http://192.168.100.21:8083/payord/getPayordGrpAll',
            update  : 'http://192.168.100.21:8083/payord/setPayordGrp',
            destroy : 'http://192.168.100.21:8083/payord/delPayordGrp'
        },
        reader: {
            type: 'json'
        },
        writer: {
            type: 'json',
            allowSingle: false, //запретить по одному отправлять отправлять объекты в Json - только массивом![объект] - иначе трудно описывать в Restful
            writeAllFields: true  //писать весь объект в json
        }
    }
});
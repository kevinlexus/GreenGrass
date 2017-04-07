/**
 * Created by lev on 13.03.2017.
 */
Ext.define('BillWebApp.model.PayordCmp', {
    extend: 'Ext.data.Model',
    identifier: {
        type: 'sequential',
        id: 'foo'
    },
    idProperty: 'id',
    fields: [
        { name: 'id', mapping: 'id', type: 'int'},
        { name: 'dtf', dateFormat: 'Y-m-d H:i:s', type: 'date', persist: false},
        { name: 'username', type: 'string', persist: false},
        { name: 'payordFk', type: 'int'},
        { name: 'varFk', type: 'int'},
        { name: 'servFk', type: 'int'},
        { name: 'orgFk', type: 'int'},
        { name: 'areaFk', type: 'int'},
        { name: 'koFk', type: 'int'},
        { name: 'koName', type: 'string', persist: false }, // Имя объекта (только для отображения)
        { name: 'mark', type: 'string' },
        { name: 'summa', type: 'float', persist: false }],
        proxy: {
            type: 'ajax',
            api: {
            create  : '',
                create  : 'http://192.168.100.21:8083/payord/addPayordCmp',
                read    : 'http://192.168.100.21:8083/payord/getPayordCmp',
                update  : 'http://192.168.100.21:8083/payord/setPayordCmp',
                destroy : 'http://192.168.100.21:8083/payord/delPayordCmp'
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
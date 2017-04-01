/**
 * This class is the view model for the Main view of the application.
 */
Ext.define('BillWebApp.view.main.MainModel', {
    extend: 'Ext.app.ViewModel',

    alias: 'viewmodel.main',

    data: {
        name: 'BillWebApp',
        loremIpsum: 'Редактирование платежек',
        periodId1: '',
        periodId2: '',
        orgId: '',
        tp: 'PAYORD_PERIODTP'
    },

    stores: {
        periodstore1: {
            type: 'periodstore1' // refers to the alias you set up on your store definition
        },
        periodstore2: {
            type: 'periodstore1'
        },
        payordstore: {
            type: 'payordstore'
        },
        payordgrpstore: {
            type: 'payordgrpstore'
        },
        payordcmpstore: {
            type: 'payordcmpstore'
        },
        lststore: {
            type: 'lststore',
            proxy : {
                extraParams : {
                    tp : 'PAYORD_PERIODTP'
                }
            }
        },
        areastore: {
            type: 'lststore',
            proxy : {
                extraParams : {
                    tp : 'AREA_TP'
                }
            }
        },
        varstore: {
            type: 'lststore',
            proxy : {
                extraParams : {
                    tp : 'PAYORD_SRC_TP'
                }
            }
        },
        addrtpspecstore: { //список типов адресов ограниченный основными типами!
            type: 'addrtpstore',
            proxy : {
                extraParams : {
                    tp : 1
                }
            }
        },
        servstore: {
            type: 'servstore'
        },
        orgstore: {
            type: 'orgstore'
        },
        orgcuruserstore: {
            type: 'orgcuruserstore'
        }
    }

});

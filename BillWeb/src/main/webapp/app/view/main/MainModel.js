/**
 * This class is the view model for the Main view of the application.
 */
Ext.define('BillWebApp.view.main.MainModel', {
    extend: 'Ext.app.ViewModel',

    alias: 'viewmodel.main',

    data: {
        name: 'BillWebApp',

        loremIpsum: 'Редактирование платежек'
    },
    stores: {
        itemstore: {
            type: 'periodstore1' // refers to the alias you set up on your store definition
        }
    }

    //TODO - add data, formulas and/or methods to support your view
});

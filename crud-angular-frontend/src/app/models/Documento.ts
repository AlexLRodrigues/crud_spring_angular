export default class Documento {
    tipoDocumento: string;
    numeroDocumento: string;

    constructor(tipoDocumento: string, numeroDocumento : string) { 
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
    }
}
import Estado from './Estado';
import Documento from './Documento';

export default class Pessoa {
    idPessoa: number;
    nomePessoa: string;
    estado: Estado;
    listaDocumento: Documento[];
}
import { useEffect, useState } from "react"
import http from '../../../Components/http'
import './style.css'


const Tabela =(props)=>{

    const[lojas,setLojas] = useState([])

    useEffect(()=>{
        http.get('loja/todas')
        .then(response=>{
            setLojas(response.data)
        })
    },[])

    return (
        
        <table>
            <thead>
                <tr>
                    <th>Nome da Loja</th>
                    <th>Nome do Dono</th>
                    <th>CPF</th>
                    <th>Saldo</th>
                </tr>
            </thead>
            <tbody className ="linhas">
                {lojas.map(loja=><tr><td>{loja.nomeLoja}</td><td>{loja.nomeDono}</td><td>{loja.cpfBeneficiario}</td><td>R$ {loja.saldo}</td></tr>)}
            </tbody>
        </table>
        
    )
}
export default Tabela;
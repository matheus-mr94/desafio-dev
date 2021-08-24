import { useState } from 'react';
import './style.css'
import http from '../http'; 

const FormCadastroLoja = () =>{

    const[nomeLoja, setNomeLoja] = useState('')
    const[nomeDono, setNomeDono] = useState('')
    const[cpfBeneficiario, setCpfBeneficiario] = useState('')
    const[saldo,setSaldo] = useState('')

    const cadastrar= (evento)=>{
        evento.preventDefault();
        const loja = {
            nomeLoja: nomeLoja,
            nomeDono: nomeDono,
            cpfBeneficiario: cpfBeneficiario,
            saldo: saldo
        }

        http.post('loja', loja)
        .then(response=>{
            console.log(response.data)
            alert("Cadastro Realizado")
        })
        .catch(erro =>{
            console.log(erro)
            alert("Erro ao cadastrar")
        })

    }

    return(
        <form onSubmit={cadastrar}>
            <div className= "boxB">
                <div>
                    <label className="label">Loja</label>
                    <input className="input" value={nomeLoja} onChange={(evento) => setNomeLoja(evento.target.value)} type="text" />
                </div>
                <div >
                    <label>Dono</label>
                    <input className="input" value={nomeDono} onChange={(evento) => setNomeDono(evento.target.value)} type="text" />
                </div>
                <div>
                    <label className="label">CPF</label>
                    <input className="input" value={cpfBeneficiario} onChange={(evento) => setCpfBeneficiario(evento.target.value)} type="text" />
                </div>
                <div>
                    <label>Saldo</label>
                    <input className="input" value={saldo} onChange={(evento) => setSaldo(evento.target.value)} type="text" />
                </div>
                <div className= "botoes">                    
                    <button className ="btn">Cadastrar</button>
                </div>
            </div>
        </form>
    )
}

export default FormCadastroLoja;
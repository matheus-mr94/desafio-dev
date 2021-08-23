import { useState } from 'react'
import { Link } from 'react-router-dom'
import http from '../http'
import './styles.css'


const FormCadastro = () =>{

    const [nome,setNome] = useState('')
    const [email, setEmail] = useState('')
    const [senha, setSenha] = useState('')


    const cadastrar = (evento) =>{
        evento.preventDefault();
        const usuario = {
            nome: nome,
            email: email,
            senha:senha
        }

        setNome('')
        setEmail('')
        setSenha('')

        http.post('usuario/cadastro', usuario)
        .then(response=>{
            console.log(response.data)
            alert("Cadastro Realizado")
        })
        .catch(erro =>{
            console.log(erro)
            alert("Erro ao cadastrar")
        })
    }


    return (
        <div className="">            
            <form onSubmit={cadastrar}>
                <div >
                    <label>Nome</label>
                    <input className="input" value={nome} onChange={(evento) => setNome(evento.target.value)} type="text" />
                </div>
                <div >
                    <label>Email </label>
                    <input className="input" value={email} onChange={(evento) => setEmail(evento.target.value)} type="email" />
                </div>
                <div>
                    <label>Senha</label>
                    <input className="input" value={senha} onChange={(evento) => setSenha(evento.target.value)} type="password" />
                </div>
                <div className= "botoes">                    
                    <button className ="btn">Cadastrar</button>
                    <Link className ="link" to="/">Já tem conta ?</Link>
                </div>
            </form>
        </div>
    )
}
export default FormCadastro;
import './styles.css'
import { useState, useEffect  } from "react"
import http from '../http'
import { Link } from 'react-router-dom'
import { useHistory} from 'react-router'


const Login = ({onLogin}) => {

    const [email, setEmail] = useState('')
    const [senha, setSenha] = useState('')

    const history = useHistory();

    

    useEffect(() => {
        localStorage.removeItem('token')
      }, [])

    const logon = (evento) => {
        evento.preventDefault()
        const usuario = {
            email: email,
            senha: senha
        }
        http.post('login', usuario)
            .then(response => {
                localStorage.setItem('token', response.data.access_token)
                localStorage.setItem('token', response.data.token)
                onLogin(response.data.token)                
                history.push('/') 
                        
                
            })
            .catch(erro => {             
                console.log(erro)
            })
           
    }


    return (
        <div >            
            <form onSubmit={logon}>
                <div >
                    <label>Email </label>
                    <input className="input" value={email} onChange={(evento) => setEmail(evento.target.value)} type="email" />
                </div>
                <div>
                    <label>Senha</label>
                    <input className="input" value={senha} onChange={(evento) => setSenha(evento.target.value)} type="password" />
                </div>
                <div className= "botoes">
                    <button className ="btn">Entrar</button>
                    <Link to="/cadastro"><button className ="btn">Cadastrar</button></Link>                    
                </div>
            </form>
        </div>
    )
}

export default Login;
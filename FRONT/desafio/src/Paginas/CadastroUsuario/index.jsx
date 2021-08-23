import FormCadastro from '../../Components/FormCadastroUsuario'
import './styles.css'
const CadastroUsuario = () => {

    return (
        <div className="container">
            <div className="header">
                <h1 className="titulo"> Desafio bycoders_</h1>
            </div>
            <div className="container2">
                <div className="box"> 
                    <div className="login">
                        <FormCadastro/>
                    </div>
                </div>
            </div>
        </div>

    )
}

export default CadastroUsuario;
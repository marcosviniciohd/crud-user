package br.com.iftm.user.api.userapi.service;

import br.com.iftm.user.api.userapi.exception.UserNotFoundException;
import br.com.iftm.user.api.userapi.model.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    public static List<UserDTO> usuarios = new ArrayList<UserDTO>();

    public UserService() {
        initiateList();
    }

    public void initiateList() {

        UserDTO user1 = new UserDTO("João", "123.456.789-00", "Rua 1", "joao.123@gmail.com", "1234-5678", LocalDateTime.now());
        UserDTO user2 = new UserDTO("Maria", "987.654.321-00", "Rua 2", "maria.silva@gmail.com", "9876-5432", LocalDateTime.now());
        UserDTO user3 = new UserDTO("Carlos", "111.222.333-44", "Rua 3", "carlos.santos@gmail.com", "1111-2222", LocalDateTime.now());
        UserDTO user4 = new UserDTO("Ana", "555.666.777-88", "Rua 4", "ana.oliveira@gmail.com", "5555-6666", LocalDateTime.now());
        UserDTO user5 = new UserDTO("Pedro", "999.888.777-66", "Rua 5", "pedro.souza@gmail.com", "9999-8888", LocalDateTime.now());
        UserDTO user6 = new UserDTO("Julia", "444.333.222-11", "Rua 6", "julia.martins@gmail.com", "4444-3333", LocalDateTime.now());
        UserDTO user7 = new UserDTO("Lucas", "222.333.444-55", "Rua 7", "lucas.lima@gmail.com", "2222-3333", LocalDateTime.now());
        UserDTO user8 = new UserDTO("Mariana", "666.777.888-99", "Rua 8", "mariana.alves@gmail.com", "6666-7777", LocalDateTime.now());
        UserDTO user9 = new UserDTO("Rafael", "333.444.555-66", "Rua 9", "rafael.ferreira@gmail.com", "3333-4444", LocalDateTime.now());
        UserDTO user10 = new UserDTO("Fernanda", "888.999.000-11", "Rua 10", "fernanda.rodrigues@gmail.com", "8888-9999", LocalDateTime.now());

        usuarios.add(user1);
        usuarios.add(user2);
        usuarios.add(user3);
        usuarios.add(user4);
        usuarios.add(user5);
        usuarios.add(user6);
        usuarios.add(user7);
        usuarios.add(user8);
        usuarios.add(user9);
        usuarios.add(user10);

    }

    public List<UserDTO> getUsuarios() {
        return usuarios;
    }

    public UserDTO buscaUsuarioPorCpf(String cpf) {
        for (UserDTO user : usuarios) {
            if (user.getCpf().equals(cpf)) {
                return user;
            }
        }
        throw new UserNotFoundException("Usuário não encontrado");
    }


    public void addUsuario(UserDTO user) {
        usuarios.add(user);
    }

    public void deletaUsuario(String cpf) {
        for (UserDTO user : usuarios) {
            if (user.getCpf().equals(cpf)) {
                usuarios.remove(user);
                return;
            }
        }
        throw new UserNotFoundException("Usuário não encontrado");
    }
}

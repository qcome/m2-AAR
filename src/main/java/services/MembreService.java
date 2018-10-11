package services;

import dao.MembreDAO;
import exceptions.LoginDejaExistantException;
import exceptions.SurnomDejaExistantException;
import model.Membre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Objects;

@Service
public class MembreService {

    @Autowired
    MembreDAO dao;


    @Transactional
    public void ajouterMembre(Membre m) throws LoginDejaExistantException, SurnomDejaExistantException {
        if (dao.findByLogin(m.getLogin()) != null)
            throw new LoginDejaExistantException();
        if(dao.findBySurname(m.getSurnom()) != null)
            throw new SurnomDejaExistantException();
        dao.insert(m);
    }

    public Membre getByLogin(String login){
        return dao.findByLogin(login);
    }

    public Membre getById(Long id){
        return dao.findById(id);
    }

    public Membre connexion(String login, String pass){
        Membre m = dao.findByLogin(login);
        if(m != null){
            if(Objects.equals(pass, m.getMotdepasse()))
                return m;
        }
        return null;
    }


}

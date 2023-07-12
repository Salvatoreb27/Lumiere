package lumiere.central.security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lumiere.central.model.Ruolo;
import lumiere.central.model.Utente;
import lumiere.central.repository.UtenteRepository;

@Service
@Primary
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UtenteRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utente utente = repository.findByEmail(username);
        if (utente == null) {
            throw new UsernameNotFoundException("Utente non trovato");
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Ruolo ruolo : utente.getRuoli()){
        	grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + ruolo.getNome()));
        	System.err.println("ruolo=" + ruolo.getNome()); //debug
        	System.err.println("grantedAuthorities=" + grantedAuthorities); //debug
        }
        User user = new User(utente.getEmail(), utente.getPassword(), grantedAuthorities);
        System.err.println("user=" + user); //debug
        //aggiunta di attributi alla sessione
        SessionUtils.setEmailAndRoles(user);
        return user;
        
    }
}

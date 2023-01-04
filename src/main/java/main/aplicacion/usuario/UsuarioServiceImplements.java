//package main.aplicacion.usuario;
//
//import java.util.Collection;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
// 
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UsuarioServiceImplements implements UsuarioService{
//
//	 	@Autowired
//	    private UsuarioRepo usuarioRepo;
//	    private Object roles;
//
//	 
//
//	    @Override
//	    public UserDetails loadUserByUsername(String nombre) throws UsernameNotFoundException {
//	        Optional<Usuario> usuario = usuarioRepo.findByNombre(nombre);
//
//	 
//
//	        if (usuario.isPresent()) {
//	            Usuario springUserMio = usuario.get();
//	            return springUserMio;
//	        } else {
//	            throw new UsernameNotFoundException("Usuario no encontrado");
//	        }
//	    }
//
//
//
//		@Override
//		public Usuario save(UsuarioDTO u) {
//			Usuario usuario = new Usuario();
//			usuario.setUsername(u.getUsername());
//			usuario.setId(u.getId());
//			usuario.setPassword(u.getPassword());
//			usuario.setRoles(u.getRoles());
//			
//			return usuarioRepo.save(usuario);
//		}
//}
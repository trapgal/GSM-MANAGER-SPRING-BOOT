package org.sid.sec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private DataSource dataSource;
@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/*
		 * auth.inMemoryAuthentication()
		 * .withUser("admin").password("1234").roles("ADMIN","USER");
		 * auth.inMemoryAuthentication()
		 * .withUser("user").password("1234").roles("USER");
		 */
	auth.jdbcAuthentication()
	.dataSource(dataSource)
	.usersByUsernameQuery("select username as principal, password as credentials, active from Utilisateur where username=?")
	.authoritiesByUsernameQuery("select username as principal, profil as role from Utilisateur where username=?") //connaitre les roles
	.rolePrefix("ROLE_"); 

}
@Override
	protected void configure(HttpSecurity http) throws Exception {
	http.formLogin().loginPage("/login");
	http.authorizeRequests().antMatchers("/Personnels","/creerPersonnels","/recherchePer","/entites","/creerEntite","/rechercheEntite",
			"/affectations","/creerAffectation","/rechercheAffectation",
			"/dotations","/creerDotation","/puces","/creerPuce","/recherchePuce").hasRole("USER");
	http.authorizeRequests().antMatchers("/Personnels","/creerPersonnels","/editPersonnel","/deletePersonnel","/recherchePer","/entites",
			"/creerEntite","/editEntite","/deleteEntite","/rechercheEntite","/affectations","/creerAffectation","/editAffectation","/deleteAffectation","/rechercheAffectation",
			"/dotations","/creerDotation","/editDotation","/deleteDotations","/puces","/creerPuce","/editPuce","/deletePuces","/recherchePuce").hasRole("ADMIN");
	
}
}

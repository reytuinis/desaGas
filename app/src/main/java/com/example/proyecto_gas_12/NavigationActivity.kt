package com.example.proyecto_gas_12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationView

class NavigationActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener{

    lateinit var toolbar: Toolbar
    lateinit var drawerLayout: DrawerLayout
    lateinit var navView: NavigationView
    /***/
    lateinit var mapaFragment: MapaFragment
    lateinit var pedidoFragment: PedidoFragment
    lateinit var listapedidosFragment: ListaPedidosFragment
    lateinit var direccionesFragment: DireccionesFragment
    lateinit var modificacioncuentaFragment: ModificacionCuentaFragment
    /***/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)

        //Partes del side bar
        toolbar = findViewById(R.id.toolBar)
        setSupportActionBar(toolbar)

        drawerLayout = findViewById(R.id.drawer_layout)
        navView = findViewById(R.id.nav_view)

        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, 0, 0
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navView.setNavigationItemSelectedListener(this)







        Log.d("llego hasta aca 0", "0")
        //El primer elemento por default seria la ubicacion del mapa
        mapaFragment = MapaFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_layout, mapaFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()

        Log.d("llego hasta aca 1", "1")



    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        Log.d("llego hasta aca 2 ", "2")
        when (item.itemId){
            R.id.nav_inicio->{
                mapaFragment = MapaFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout, mapaFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }

            R.id.nav_comprar_balon->{
                pedidoFragment = PedidoFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout, pedidoFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }

            R.id.nav_mis_pedidos->{
                listapedidosFragment = ListaPedidosFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout, listapedidosFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }

            R.id.nav_mis_direcciones->{
                direccionesFragment = DireccionesFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout, direccionesFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }
            R.id.cuenta->{
                modificacioncuentaFragment = ModificacionCuentaFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout, modificacioncuentaFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START)
        }
        else{
            super.onBackPressed()
        }
    }


}

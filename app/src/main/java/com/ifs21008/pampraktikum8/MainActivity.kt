package com.ifs21008.pampraktikum8

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import com.ifs21008.pampraktikum8.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()
        setupAction()
    }

    private fun setupView() {
        binding.navView.setCheckedItem(R.id.nav_inboxes)

        binding.inAppBar.toolbar.overflowIcon =
            ContextCompat.getDrawable(this, R.drawable.ic_more_vert)

        loadFragment(FLAG_FRAGMENT_EMAIL)
    }

    private fun setupAction() {
        binding.inAppBar.toolbar.setNavigationOnClickListener {
            binding.drawerLayout.openDrawer(GravityCompat.START)
        }
        binding.inAppBar.toolbar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.action_add -> {
                    loadFragment(FLAG_FRAGMENT_EMAIL, "Memilih menu Add!")
                    true
                }

                R.id.action_settings -> {
                    loadFragment(FLAG_FRAGMENT_EMAIL, "Memilih menu Settings!")
                    true
                }

                R.id.action_logout -> {
                    loadFragment(FLAG_FRAGMENT_EMAIL, "Memilih menu Logout!")
                    true
                }

                else -> true
            }
        }

        binding.navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_inboxes -> {
                    loadFragment(FLAG_FRAGMENT_EMAIL)
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }

                R.id.nav_primary -> {
                    loadFragment(FLAG_FRAGMENT_EMAIL, "Memilih menu Profile!")
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }

                R.id.nav_social -> {
                    loadFragment(FLAG_FRAGMENT_EMAIL, "Memilih menu Notes!")
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }

                else -> true
            }
        }

        binding.inAppBar.bottomNavView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_email -> {
                    loadFragment(FLAG_FRAGMENT_EMAIL)
                    true
                }

                R.id.navigation_meet -> {
                    loadFragment(FLAG_FRAGMENT_MEET)
                    true
                }

                else -> true
            }
        }
    }

    private fun loadFragment(flag: String, message: String? = null) {
        val fragmentManager = supportFragmentManager
        val fragmentContainerId =
            binding.inAppBar.inContentMain.frameContainer.id

        when (flag) {
            FLAG_FRAGMENT_EMAIL -> {
                binding.inAppBar.bottomNavView
                    .menu
                    .findItem(R.id.navigation_email)
                    .setChecked(true)

                val homeFragment = HomeFragment()

                val bundle = Bundle().apply {
                    this.putString(
                        HomeFragment.EXTRA_MESSAGE,
                        message ?: "Belum ada menu yang dipilih!"
                    )
                }
                homeFragment.arguments = bundle

                fragmentManager
                    .beginTransaction()
                    .replace(
                        fragmentContainerId,
                        homeFragment,
                        HomeFragment::class.java.simpleName
                    )
                    .commit()
            }

            FLAG_FRAGMENT_MEET -> {
                val dashboardFragment = DashboardFragment()
                val fragment = fragmentManager .findFragmentByTag(DashboardFragment::class.java.simpleName)

                if (fragment !is DashboardFragment) {
                    fragmentManager
                        .beginTransaction()
                        .replace(
                            fragmentContainerId,
                            dashboardFragment,
                            DashboardFragment::class.java.simpleName
                        )
                        .commit()
                }
            }
        }
    }

    companion object {
        const val FLAG_FRAGMENT_EMAIL = "fragment_email"
        const val FLAG_FRAGMENT_MEET = "fragment_meet"
    }

}

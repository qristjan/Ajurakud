using AjuServiis.Models.Entities;
using Microsoft.EntityFrameworkCore;

namespace AjuServiis.DbContext
{
    public class MemeDbContext : Microsoft.EntityFrameworkCore.DbContext
    {
        private readonly string _connectionString;

        public MemeDbContext(string connectionString) 
            => _connectionString = connectionString;

        public MemeDbContext() 
            => _connectionString = "Data Source=:memory:;";

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
            => optionsBuilder.UseSqlite(_connectionString);

        protected override void OnModelCreating(ModelBuilder modelBuilder)
            =>
                modelBuilder.Entity<MemeEntity>()
                    .HasKey(meme => new {meme.Id});
        
        public static void RunMigraton(string connection)
        {
            using (var db = new MemeDbContext(connection))
            {
                db.Database.Migrate();
            };
            
        }
    }
}
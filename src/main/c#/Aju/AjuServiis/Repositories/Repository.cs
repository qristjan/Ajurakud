using System.Collections.Generic;
using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.Options;

namespace AjuServiis.Repositories
{
    public class Repository<TEntity> : IRepository<TEntity> where TEntity : class
    {
        private readonly string _connectionString;

        public Repository()
        {
            
        }

        public DbSet<TEntity> Set { get; } = null;
        public TEntity Get(params object[] key)
        {
            throw new System.NotImplementedException();
        }

        public void Insert(TEntity entity)
        {
            throw new System.NotImplementedException();
        }

        public void InsertRange(IEnumerable<TEntity> entities)
        {
            throw new System.NotImplementedException();
        }

        public void Update(TEntity entity)
        {
            throw new System.NotImplementedException();
        }

        public void Remove(TEntity entity)
        {
            throw new System.NotImplementedException();
        }

        public void RemoveByKey(params object[] key)
        {
            throw new System.NotImplementedException();
        }
    }
}
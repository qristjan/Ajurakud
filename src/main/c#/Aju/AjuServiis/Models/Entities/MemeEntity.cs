using System;

namespace AjuServiis.Models.Entities
{
    public class MemeEntity
    {
        public Guid Id { get; set; } 
            
        public string Name { get; set; }
        
        public string Description { get; set; }
        
        public string ImageBase64 { get; set; }

        public DateTime CreationTime { get; set; }
        
        public DateTime DeadTime { get; set; }

        public bool IsDead => DeadTime <= DateTime.UtcNow;
    }
}